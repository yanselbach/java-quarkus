import {TaskItemType} from "../types";
import {createContext, ReactNode, useEffect, useState} from "react";

interface MainContextInterface {
  todos: TaskItemType[];
  setTodos: React.Dispatch<React.SetStateAction<TaskItemType[]>>;
  markComplete: (id: string) => void;
  delTodo: (id: string) => void;
  deleteAll: () => void;
  editTodo: (id: string, text: string) => void;
  addTodo: (title: string) => void;
  moveTodo: (old: number, new_: number) => void;
  markStar: (id: string) => void;
}

interface Props {
  children: ReactNode;
}

export const MainContext = createContext<MainContextInterface | null>(null);

export const MainProvider = ({ children }: Props) => {
  const [todos, setTodos] = useState<TaskItemType[]>(
    JSON.parse(localStorage.getItem("todos")!) || []
  );

  useEffect(() => {
    localStorage.setItem("todos", JSON.stringify(todos));
  }, [todos]);

  const addTodo = (title: string) => {
    if (title.trim()) {
      const taskItem = {
        // id: String(Math.random() * 5000),
        title,
        completed: false,
        starred: false,
        taskListId: 1,
        //deadline: ""
      };

      // Send data to the backend via POST
      fetch('http://localhost:8080/task/item/save', {  // Enter your IP address here

        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(taskItem) // body data type must match "Content-Type" header

      })
      .then((response) => response.json())
      .then((newId) => {
          const savedItem = [Object.assign({id: "" + newId}, taskItem)];
          const orderTodos = [savedItem, ...todos];
          orderStarAndComplete(savedItem);
          setTodos(savedItem);
      })
      .catch((error) => {
        console.error(error);
      });
    }
  };
  const editTodo: (id: string, text: string) => void = (
    id: string,
    text: string
  ) => {
    if (!(text === null) && text.trim()) {
      setTodos(
        todos.map((todo) => {
          if (todo.id === id) todo.title = text;
          return todo;
        })
      );
    }
  };
  const markComplete = (id: string) => {
    const orderTodos = todos.map((todo) => {
      if (todo.id === id) todo.completed = !todo.completed;
      return todo;
    });
    orderStarAndComplete(orderTodos);
    setTodos(orderTodos);
  };

  const markStar = (id: string) => {
    const orderTodos = todos.map((todo) => {
      if (todo.id === id) todo.starred = !todo.starred;
      return todo;
    });
    orderStarAndComplete(orderTodos);
    setTodos(orderTodos);
  };

  const orderStarAndComplete = (todos: TaskItemType[]) => {
    todos.sort((x, y) => y.starred - x.starred);
    todos.sort((x, y) => x.completed - y.completed);
  };

  const delTodo = (id: string) =>
    setTodos(todos.filter((todo) => todo.id !== id));
  const deleteAll = () => setTodos([]);
  const moveTodo = (old: number, new_: number) => {
    const copy = JSON.parse(JSON.stringify(todos));
    const thing = JSON.parse(JSON.stringify(todos[old]));
    copy.splice(old, 1);
    copy.splice(new_, 0, thing);
    setTodos(copy);
  };

  const mainContextValue: MainContextInterface = {
    todos,
    setTodos,
    markComplete,
    delTodo,
    deleteAll,
    editTodo,
    addTodo,
    moveTodo,
    markStar,
  };

  return (
    <MainContext.Provider value={mainContextValue}>
      {children}
    </MainContext.Provider>
  );
};
