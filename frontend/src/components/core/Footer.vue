<template>
  <div
    id="dashboard-core-footer"
  >
    <v-container>
      <v-row
        align="center"
        no-gutters
      >
        <v-spacer class="hidden-sm-and-down" />

        <v-col
          cols="12"
          md="auto"
        >
          <div class="body-1 font-weight-light pt-0 pt-md-0 text-center">
            &copy; 2021, made with
            <v-icon size="18">
              mdi-heart
            </v-icon>
            by <a href="https://vvv09.github.io">Fra. Q.L.</a> for a better great work.
          </div>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
  export default {
    name: 'DashboardCoreFooter',
  }
</script>

<style lang="sass">
  #dashboard-core-footer
    a
      font-size: .825rem
      font-weight: 500
      text-decoration: none
      text-transform: uppercase
</style>
