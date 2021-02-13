<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-container
    id="user-profile"
    fluid
    tag="section"
  >
    <v-row justify="center">
      <v-col
        cols="12"
        md="8"
      >
        <base-material-card>
          <template v-slot:heading>
            <div class="display-2 font-weight-light">
              Today Entry
            </div>

            <div class="subtitle-1 font-weight-light">

              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <span v-bind="attrs" v-on="on">восход: {{entry.sunriseTime}}</span>
                </template>
                <span>Верхний край солнца выходит из-за горизонта</span>
              </v-tooltip>
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <span v-bind="attrs" v-on="on"> / закат: {{entry.sunsetTime}}</span>
                </template>
                <span>Нижний край солнца касается горизонта</span>
              </v-tooltip>
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <span v-bind="attrs" v-on="on"> / луна: {{entry.moonPhase}}</span>
                </template>
                <span>0-0.5 - растущая луна;0-0.5 - стареющая луна</span>
              </v-tooltip>
            </div>
          </template>

          <v-form>
            <v-container class="py-0">
              <v-row>
                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Date"
                    disabled
                    v-model="entry.date"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    class="purple-input"
                    label="Time"
                    v-model="entry.time"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Duration"
                    class="purple-input"
                    v-model="entry.duration"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Salutation (morning)"
                    class="purple-input"
                    v-model="entry.salutation1"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Salutation (noon)"
                    class="purple-input"
                    v-model="entry.salutation2"
                  />
                </v-col>

                <v-col
                  cols="12"
                  md="4"
                >
                  <v-text-field
                    label="Salutation (evening)"
                    class="purple-input"
                    v-model="entry.salutation3"
                  />
                </v-col>

                <v-col cols="12">
                  <v-textarea
                    outlined
                    rows="1"
                    auto-grow
                    class="purple-input"
                    label="Meditation"
                    v-model="entry.meditationField"
                  />
                </v-col>

                <v-col cols="12">
                  <v-textarea
                    outlined
                    rows="1"
                    auto-grow
                    class="purple-input"
                    label="Results"
                    v-model="entry.resultField"
                    title="questions, difficulties, impressions, realizations"
                  />
                </v-col>

                <v-col cols="12">
                  <v-textarea
                    outlined
                    rows="1"
                    auto-grow
                    class="purple-input"
                    label="Daily life"
                    v-model="entry.dailyLifeField"
                    title="feeling better, job is a bore, have a new friend, etc."
                  />
                </v-col>

                <v-col cols="12">
                  <v-textarea
                    outlined
                    rows="1"
                    auto-grow
                    class="purple-input"
                    v-model="entry.otherField"
                    label="Other"
                    title="dreams, books read, lectures, group meetings, etc."
                  />
                </v-col>

                <v-col
                  cols="12"
                  class="text-right"
                >
                  <v-btn
                    color="success"
                    class="mr-0"
                    @click="updateEntry"
                  >
                    Update Entry
                  </v-btn>

                  <v-snackbar
                    v-model="snackbar"
                    :timeout="2000"
                    top
                    :color="snackbarColor"
                    right
                    elevation="24"
                  >
                    {{ snackbarText }}
                  </v-snackbar>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </base-material-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

  import Service from '@/services/entry.service.js'
  import AstroCalcService from '@/services/astro.calc.service.js'

  export default {
    name: 'Today',
    data () {
      return {
        entry: {},
        snackbar: false,
        timeout: 2000,
        snackbarText: '',
        snackbarColor: '',
        astrology: {}
      }
    },
    mounted () {
      this.astrology = AstroCalcService.getForToday()
      this.refreshData()
    },
    methods: {
      updateEntry() {
        Service.update(this.entry).then((response) => {
          if (response.status == 200) {
            this.entry = response.data
            this.snackbarColor = 'success'
            this.snackbarText = 'Successfully updated'
            this.snackbar = true
          }
        }).catch(err => {
          this.snackbarColor = 'error'
          this.snackbarText = 'Updating error!!! ' + err
          this.snackbar = true
        })
      },
      refreshData() {
        console.log(this.astrology)
        Service.retrieveForToday(this.astrology)
          .then((response) => {
            if (response.status == 200) {
              this.entry = response.data
              console.log(response.data)
            }
          })
      }
    }
  }
</script>
