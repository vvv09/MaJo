<template>
  <v-container
    id="regular-tables"
    fluid
    tag="section"
  >
    <div v-if="!addNew">
    <base-material-card
      icon="mdi-archive"
      title="My diary"
      class="px-5 py-3"
    >
      <v-btn
      class="ml-2"
      min-width="0"
      text
      @click="addEntry"
    >
      <v-icon>mdi-plus</v-icon>
    </v-btn>
      <v-menu
        bottom
        offset-y
        origin="top right"
        transition="scale-transition"
      >
        <template v-slot:activator="{ attrs, on }">
          <v-btn
            class="ml-2"
            min-width="0"
            text
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-format-list-bulleted-square</v-icon>
          </v-btn>
        </template>

        <v-list
          :tile="false"
          nav
        >
          <div>
            <app-bar-item
              v-for="(o, i) in options"
              :key="`item-${i}`"
            >
              <v-list-item-title v-text="o" />
            </app-bar-item>
          </div>
        </v-list>
      </v-menu>
     <entry-table
       :entries="diary"
        @update="updateEntry"/>
    </base-material-card>
    </div>
    <entry-form
      v-else
      :entry="entry"
      @delete="del"
      @create="create"
      @update="update"
      @cancel="cancel"/>
    <div class="py-3" />
  </v-container>
</template>

<script>
  import EntryForm from '@/views/diary/EntryForm'
  import EntryTable from '@/views/diary/EntryTable'
  import Service from '@/services/entry.service.js'

  export default {
    name: 'Diary',
    components: {
      EntryForm, EntryTable
    },
    data () {
      return {
        diary: [],
        entry: {},
        options: [
          'Mike John Responded to your email',
          'You have 5 new tasks',
          'You\'re now friends with Andrew',
          'Another Notification',
          'Another one',
        ],
        addNew: false
      }
    },
    mounted () {
      this.refreshList()
    },
    methods: {
      addEntry() {
        this.addNew = true
      },
      updateEntry(entry) {
        console.log("update", entry)
        this.entry = entry
        this.addNew = true
      },
      refreshList() {
        Service.retrieveAll()
          .then((response) => {
            this.diary = response.data
            console.log(this.diary)
            this.addNew = false
            this.entry = {}
          })
      },
      cancel() {
        console.log("canceling")
        this.entry = {}
        this.addNew = false
      },
      create(entry){
        Service.create(entry)
          .then(() => {
            this.refreshList()
          })
      },
      update(entry){
        Service.update(entry)
          .then(() => {
            this.refreshList()
          })
      },
      del(entry){
        Service.delete(entry.id)
          .then(() => {
            this.refreshList()
          })
      }
    }
  }
</script>
