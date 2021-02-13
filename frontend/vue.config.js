module.exports = {
  devServer: {
    disableHostCheck: true,
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
