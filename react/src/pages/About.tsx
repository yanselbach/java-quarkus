import { Container } from "@material-ui/core";
import {
  GitHub,
  YouTube,
  Instagram,
    Group
} from "@material-ui/icons";

const About = () => {
  return (
    <>
      <Container>
        <p style={{ fontSize: "1.3rem" }}>
          <b>My Todos</b> is a simple Todo App built using React.js and styled using Material UI.
        </p>
        <h2>devonfw</h2>
        <a
          href="https://github.com/devonfw/"
          style={{
            color: "#24292E",
            textDecoration: "none",
            fontSize: "24px",
          }}
          target="_blank"
          rel="noopener noreferrer"
        >
          <GitHub fontSize="large" />
        </a>
        <a
          href="https://www.youtube.com/channel/UCtb1p-24jus-QoXy49t9Xzg"
          style={{
            color: "#FD0000",
            textDecoration: "none",
            fontSize: "24px",
          }}
          target="_blank"
          rel="noopener noreferrer"
        >
          <YouTube fontSize="large" />
        </a>
        <a
          href="https://teams.microsoft.com/l/team/19%3af92c481ec30345a28a5434bc530a882a%40thread.skype/conversations?groupId=503df57a-d454-4eec-b3bc-d6d87c7c24f8&tenantId=76a2ae5a-9f00-4f6b-95ed-5d33d77c4d61"
          style={{
            color: "#702ecd",
            textDecoration: "none",
            fontSize: "24px",
          }}
          target="_blank"
          rel="noopener noreferrer"
        >
          <Group fontSize="large" />
        </a>
      </Container>
    </>
  );
};

export default About;
