<template>
  <v-navigation-drawer
    id="core-navigation-drawer"
    v-model="drawer"
    :dark="barColor !== 'rgba(228, 226, 226, 1), rgba(255, 255, 255, 0.7)'"
    :expand-on-hover="expandOnHover"
    :src="barImage"
    mobile-break-point="960"
    app
    width="260"
    v-bind="$attrs"
  >
    <template v-slot:img="props">
      <v-img
        :gradient="`to bottom, ${barColor}`"
        v-bind="props"
      />
    </template>

    <v-divider class="mb-1" />

    <v-list>
<!--      <v-list-item class="px-2">-->
<!--        <v-list-item-avatar>-->
<!--          <v-img src="https://randomuser.me/api/portraits/women/85.jpg"></v-img>-->
<!--        </v-list-item-avatar>-->
<!--      </v-list-item>-->

      <v-list-item link>
        <v-list-item-content>
          <v-list-item-title class="title">
            AMBULANDO
          </v-list-item-title>
          <v-list-item-subtitle>on the going...</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-divider class="mb-2" />

    <v-list
      expand
      nav
    >
      <!-- Style cascading bug  -->
      <!-- https://github.com/vuetifyjs/vuetify/pull/8574 -->
      <div />

      <template v-for="(item, i) in computedItems">
        <base-item-group
          v-if="item.children"
          :key="`group-${i}`"
          :item="item"
        >
          <!--  -->
        </base-item-group>

        <base-item
          v-else
          :key="`item-${i}`"
          :item="item"
        />
      </template>

      <!-- Style cascading bug  -->
      <!-- https://github.com/vuetifyjs/vuetify/pull/8574 -->
      <div />
    </v-list>
    <template v-slot:append>
      <div class="pa-2">
        <v-btn block @click.prevent="logOut">
          <v-icon>mdi-logout</v-icon> Logout
        </v-btn>
      </div>
    </template>
  </v-navigation-drawer>
</template>

<script>
  // Utilities
  import {
    mapState,
  } from 'vuex'

  export default {
    name: 'DashboardCoreDrawer',

    props: {
      expandOnHover: {
        type: Boolean,
        default: false,
      },
    },

    data: () => ({
      items: [
        {
          title: 'Today',
          icon: 'mdi-clipboard-outline',
          to: '/',
        },
        {
          title: 'Dairy',
          icon: 'mdi-archive',
          to: '/archive',
        },
        {
          title: 'Dashboard',
          icon: 'mdi-view-dashboard',
          to: '/dashboard',
        },
        {
          title: 'Calendar',
          icon: 'mdi-calendar',
          to: '/calendar',
        },
        {
          icon: 'mdi-account',
          title: 'user',
          to: '/profile',
        },
      ],
    }),

    computed: {
      ...mapState(['barColor', 'barImage']),
      ...mapState({
        drawer: state => state.settings.drawer,
      }),
      // drawer: {
      //   get () {
      //     return this.$store.state.drawer
      //   },
      //   set (val) {
      //     this.$store.dispatch('settings/setDrawer', val)
      //   },
      // },
      computedItems () {
        return this.items.map(this.mapItem)
      },
      profile () {
        return {
          avatar: true,
          title: this.$t('avatar'),
        }
      },
    },

    methods: {
      logOut() {
        this.$store.dispatch('auth/logout');
        this.$router.push('/login');
      },
      mapItem (item) {
        return {
          ...item,
          children: item.children ? item.children.map(this.mapItem) : undefined,
          title: this.$t(item.title),
        }
      },
    },
  }
</script>

<style lang="sass">
  @import '../../../node_modules/vuetify/src/styles/tools/rtl'

  #core-navigation-drawer
    .v-list-group__header.v-list-item--active:before
      opacity: .24

    .v-list-item
      &__icon--text,
      &__icon:first-child
        justify-content: center
        text-align: center
        width: 20px

        +ltr()
          margin-right: 24px
          margin-left: 12px !important

        +rtl()
          margin-left: 24px
          margin-right: 12px !important

    .v-list--dense
      .v-list-item
        &__icon--text,
        &__icon:first-child
          margin-top: 10px

    .v-list-group--sub-group
      .v-list-item
        +ltr()
          padding-left: 8px

        +rtl()
          padding-right: 8px

      .v-list-group__header
        +ltr()
          padding-right: 0

        +rtl()
          padding-right: 0

        .v-list-item__icon--text
          margin-top: 19px
          order: 0

        .v-list-group__header__prepend-icon
          order: 2

          +ltr()
            margin-right: 8px

          +rtl()
            margin-left: 8px
</style>
