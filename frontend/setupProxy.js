const { createProxyMiddleware } = require('http-proxy-middleware');

const proxy = {
    target: 'http://localhost:8080',
    changeOrigin: true,
    pathRewrite: {
        '^/api/': '/' // remove base path
    }
};

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware(proxy)
    );
};