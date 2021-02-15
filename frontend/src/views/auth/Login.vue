<template>

  <v-container
    class="grey lighten-5 mb-6"
  >
    <v-row
      align="center"
      no-gutters
      style="height: 500px;"
    >
      <v-col
      >
        <v-overlay
          :absolute="absolute"
          :opacity="opacity"
          :value="overlay"
        >

  <v-card
    class="mx-auto"
    max-width="344"
    elevation="24"
    :loading="loading"
    shaped
  >
  <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
    <form @submit.prevent="submit">
    <v-card-text>
      <validation-provider
        v-slot="{ errors }"
        name="Username"
        rules="required|max:10"
      >
        <v-text-field
          v-model="username"
          :counter="10"
          :error-messages="errors"
          label="Username"
          required
        ></v-text-field>
      </validation-provider>
      <validation-provider
        v-slot="{ errors }"
        name="password"
        rules="required"
      >
        <v-text-field
          v-model="password"
          type="password"
          :error-messages="errors"
          label="Password"
          required
        ></v-text-field>
      </validation-provider>
      {{message}}
      </v-card-text>
      <v-card-actions>
      <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
      >
        submit
      </v-btn>
      <v-btn @click="clear">
        clear
      </v-btn>
      </v-card-actions>
    </form>
  </validation-observer>
  </v-card>
        </v-overlay>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
  import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'

  setInteractionMode('eager')

  extend('required', {
    ...required,
    message: '{_field_} can not be empty',
  })

  extend('max', {
    ...max,
    message: '{_field_} may not be greater than {length} characters',
  })

  import User from '@/models/user';

  export default {
    components: {
      ValidationProvider,
      ValidationObserver,
    },
    data: () => ({
      username: '',
      password: '',
      loading: false,
      message: ''
    }),
    computed: {
      loggedIn() {
        return this.$store.state.auth.status.loggedIn;
      }
    },
    created() {
      if (this.loggedIn) {
        this.$router.push('/');
      }
      this.$store.dispatch('settings/setDrawer', false)
    },
    methods: {
      submit () {
        if (this.$refs.observer.validate()) {
          console.log("valid")
          this.loading = true;
          console.log("this.loading", this.loading)

          if (this.username && this.password) {
            const user = new User (this.username, '', this.password)
            console.log("user", user)
            this.$store.dispatch('auth/login', user).then(
              () => {
                this.$store.dispatch('settings/setDrawer', true)
                this.$router.push('/');
              },
              error => {
                this.loading = false
                console.log('-error.response\n', error.response)
                this.message = error.response.data.message
              }
            );
          }
        }
      },
      clear () {
        this.username = ''
        this.password = ''
        this.message = ''
        this.$refs.observer.reset()
      }
    },
  }
</script>
