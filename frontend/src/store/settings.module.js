

export const settings = {
  namespaced: true,
  state: {
    barColor: 'rgba(0, 0, 0, .8), rgba(0, 0, 0, .8)',
    barImage: 'https://demos.creative-tim.com/material-dashboard/assets/img/sidebar-1.jpg',
    drawer: false,
  },
  mutations: {
    SET_BAR_IMAGE (state, payload) {
      state.barImage = payload
    },
    SET_DRAWER (state, payload) {
      console.log('inside SET_DRAWER')
      state.drawer = payload
      console.log("state.drawer", state.drawer)
    },
  },
  actions: {
    setDrawer({ commit }, payload) {
      console.log('inside action')
      commit('SET_DRAWER', payload);
    },
  },
}
