<template>
  <v-row justify="center">
    <v-col
      cols="12"
      md="8"
    >
      <base-material-card>

        <template v-if="isUpdating" v-slot:heading>
          <div class="display-2 font-weight-light">
            Update Entry
          </div>

          <div class="subtitle-1 font-weight-light">
            Update existing entry
          </div>
        </template>

        <template v-else v-slot:heading>
          <div class="display-2 font-weight-light">
            New Entry
          </div>

          <div class="subtitle-1 font-weight-light">
            Create new entry
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
                  rows="1"
                  outlined
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
                  elevation="2"
                  outlined
                  raised
                  rounded
                  color="success"
                  class="mr-5"
                  @click="$emit('cancel')"
                >
                  Cancel
                </v-btn>
                <v-btn
                  v-if="isUpdating"
                  color="success"
                  class="mr-5"
                  @click="updateEntry"
                >
                  Update Entry
                </v-btn>
                <v-btn
                  v-if="isUpdating"
                  fab
                  dark
                  small
                  color="pink"
                  @click.stop="showDeleteDialog = true"
                >
                  <v-icon dark>
                    mdi-delete
                  </v-icon>
                </v-btn>
                <v-btn
                  v-if="!isUpdating"
                  color="success"
                  class="mr-0"
                  @click="createEntry"
                >
                  Create Entry
                </v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-form>
      </base-material-card>
    </v-col>

    <v-dialog
      v-model="showDeleteDialog"
      max-width="290"
    >
      <v-card>
        <v-card-title class="headline">
          Delete entry?
        </v-card-title>

        <v-card-text>
          You won't be able to restore it in the future!
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn
            color="green darken-1"
            text
            @click="showDeleteDialog = false"
          >
            Cancel
          </v-btn>

          <v-btn
            color="red darken-1"
            text
            @click="deleteEntry"
          >
            Delete
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>

  import Service from '@/services/entry.service.js'
    export default {
        name: "EntryForm",
        props: ['entry'],
        computed: {
          isUpdating: function() {
            return this.entry.id ? true : false
          }
        },
        data () {
          return {
            showDeleteDialog: false,
          }
        },
        methods: {
          createEntry() {
            if (this.entry.date) {
              this.$emit("create", this.entry)
            }
          },
          updateEntry() {
            console.log("update", this.entry)
            if (this.entry.date) {
              this.$emit("update", this.entry)
            }
          },
          deleteEntry() {
            this.showDeleteDialog = false
            this.$emit("delete", this.entry)
          },
        }
    }
</script>

<style scoped>

</style>
