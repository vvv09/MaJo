<template>
  <base-material-card
    color="warning"
    class="px-5 py-3"
  >
    <template v-slot:heading>
      <div class="display-2 font-weight-light">
        AstroCalculator
      </div>
      <div class="subtitle-1 font-weight-light">
        To get time of sunrise, sunset as well as phase of the Moon
      </div>
    </template>
    <v-card-text>
      <v-row>

        <v-col
          class="px-1"
          cols="12"
          sm="4"
        >
          <v-simple-table>
            <template v-slot:default>
              <tbody>
              <tr>
                <td>date</td>
                <td>{{ data.date }}</td>
              </tr>
              <tr>
                <td>sunrise</td>
                <td>{{ data.sunrise }}</td>
              </tr>
              <tr>
                <td>sunset</td>
                <td>{{ data.sunset }}</td>
              </tr>
              <tr>
                <td>moonphase</td>
                <td>{{ data.moonphase }}</td>
              </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-col>


        <v-col
          class="px-1"
          cols="12"
          sm="8"
        >
          <v-date-picker
            v-model="date"
            no-title
            :first-day-of-week="1"
            locale="ru-Ru"
            full-width
          ></v-date-picker>
        </v-col>


      </v-row>
    </v-card-text>
  </base-material-card>
</template>

<script>
  import AstroService from '@/services/astrology.service'
  import serv from '@/services/astro.calc.service'

    export default {
      name: "AstroCalculator",
      data: () => ({
        date: new Date().toISOString().substr(0, 10),
        data: {
          data: '',
          sunrise: '',
          sunset: '',
          moonPhase: '',
        }
      }),
      methods: {
        getData() {
          const lon = 30.3350986
          const lan = 59.9342802
          AstroService.retrieveForDayPlace(
            this.date,
            lon,
            lan
          ).then((response) => {
            this.data = response.data.data
          })
        }
      },
      mounted() {
        this.getData();
      },
      watch: {
        date: function (val) {
          console.log(val)
          this.getData()
        }
      }
    }
</script>

<style scoped>

</style>
