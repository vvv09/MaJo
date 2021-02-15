<template>
  <v-simple-table
    fixed-header
    height="800px">
    <thead>
    <tr>
      <th></th>
      <th class="primary--text">
        Date
      </th>
      <th class="primary--text">
        Moon phase
      </th>
      <th class="primary--text">
        Sunrise/Sunset
      </th>
      <th class="primary--text">
        Salutation morning
      </th>
      <th class="primary--text">
        Salutation noon
      </th>
      <th class="primary--text">
        Salutation evening
      </th>
    </tr>
    </thead>

    <tbody>
    <tr v-for="entry in entries" :key="entry.id" @click="update(entry)">
      <td :class="getDayColor(entry.dayOfWeek)"></td>
      <td>{{entry.date}}</td>
      <td>{{entry.moonPhase}}</td>
      <td>{{entry.sunriseTime}} / {{entry.sunsetTime}}</td>
      <td>{{entry.salutation1 ? entry.salutation1 : '-'}}</td>
      <td>{{entry.salutation2 ? entry.salutation2 : '-'}}</td>
      <td>{{entry.salutation3 ? entry.salutation3 : '-'}}</td>
    </tr>
    </tbody>
  </v-simple-table>
</template>

<script>
    export default {
      name: "EntryTable",
      props: ['entries'],
      methods: {
        update(entry) {
          console.log("upd", entry)
          this.$emit("update", entry)
        },
        getDayColor(dayNumber) {
          if (dayNumber == 1) return "purple"
          if (dayNumber == 2) return "red"
          if (dayNumber == 3) return "orange"
          if (dayNumber == 4) return "blue"
          if (dayNumber == 5) return "green"
          if (dayNumber == 6) return "black"
          if (dayNumber == 7) return "yellow"
        }
      },
      computed:{

      }
    }
</script>

<style scoped>

</style>
