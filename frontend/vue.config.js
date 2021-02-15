module.exports = {
  devServer: {
    disableHostCheck: true,
    proxy: {
      '/api': {
        target: 'http://localhost:8999', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
        ws: true,
        changeOrigin: true
      }
    }
  },
  outputDir: 'target/dist',
  assetsDir: 'static',

  transpileDependencies: ['vuetify'],

  pluginOptions: {
    i18n: {
      locale: 'en',
      fallbackLocale: 'en',
      localeDir: 'locales',
      enableInSFC: false,
    },
  },
}
