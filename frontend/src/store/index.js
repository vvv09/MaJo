import Vue from 'vue';
import Vuex from 'vuex';

import {auth} from './auth.module';
import {settings} from './settings.module';

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        auth,
        settings
    }
});
