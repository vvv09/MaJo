<template>
  <v-container
    id="dashboard"
    fluid
    tag="section"
  >
    <v-row>
      <v-col
        cols="12"
        lg="4"
      >
        <base-material-chart-card
          :data="emailsSubscriptionChart.data"
          :options="emailsSubscriptionChart.options"
          :responsive-options="emailsSubscriptionChart.responsiveOptions"
          color="#E91E63"
          hover-reveal
          type="Bar"
        >
          <template v-slot:reveal-actions>
            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  color="info"
                  icon
                  v-on="on"
                >
                  <v-icon
                    color="info"
                  >
                    mdi-refresh
                  </v-icon>
                </v-btn>
              </template>

              <span>Refresh</span>
            </v-tooltip>

            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  light
                  icon
                  v-on="on"
                >
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
              </template>

              <span>Change Date</span>
            </v-tooltip>
          </template>

          <h4 class="card-title font-weight-light mt-2 ml-2">
            Website Views
          </h4>

          <p class="d-inline-flex font-weight-light ml-2 mt-1">
            Last Campaign Performance
          </p>

          <template v-slot:actions>
            <v-icon
              class="mr-1"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">updated 10 minutes ago</span>
          </template>
        </base-material-chart-card>
      </v-col>

      <v-col
        cols="12"
        lg="4"
      >
        <base-material-chart-card
          :data="dailySalesChart.data"
          :options="dailySalesChart.options"
          color="success"
          hover-reveal
          type="Line"
        >
          <template v-slot:reveal-actions>
            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  color="info"
                  icon
                  v-on="on"
                >
                  <v-icon
                    color="info"
                  >
                    mdi-refresh
                  </v-icon>
                </v-btn>
              </template>

              <span>Refresh</span>
            </v-tooltip>

            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  light
                  icon
                  v-on="on"
                >
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
              </template>

              <span>Change Date</span>
            </v-tooltip>
          </template>

          <h4 class="card-title font-weight-light mt-2 ml-2">
            Daily Sales
          </h4>

          <p class="d-inline-flex font-weight-light ml-2 mt-1">
            <v-icon
              color="green"
              small
            >
              mdi-arrow-up
            </v-icon>
            <span class="green--text">55%</span>&nbsp;
            increase in today's sales
          </p>

          <template v-slot:actions>
            <v-icon
              class="mr-1"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">updated 4 minutes ago</span>
          </template>
        </base-material-chart-card>
      </v-col>

      <v-col
        cols="12"
        lg="4"
      >
        <base-material-chart-card
          :data="dataCompletedTasksChart.data"
          :options="dataCompletedTasksChart.options"
          hover-reveal
          color="info"
          type="Line"
        >
          <template v-slot:reveal-actions>
            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  color="info"
                  icon
                  v-on="on"
                >
                  <v-icon
                    color="info"
                  >
                    mdi-refresh
                  </v-icon>
                </v-btn>
              </template>

              <span>Refresh</span>
            </v-tooltip>

            <v-tooltip bottom>
              <template v-slot:activator="{ attrs, on }">
                <v-btn
                  v-bind="attrs"
                  light
                  icon
                  v-on="on"
                >
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
              </template>

              <span>Change Date</span>
            </v-tooltip>
          </template>

          <h3 class="card-title font-weight-light mt-2 ml-2">
            Completed Tasks
          </h3>

          <p class="d-inline-flex font-weight-light ml-2 mt-1">
            Last Last Campaign Performance
          </p>

          <template v-slot:actions>
            <v-icon
              class="mr-1"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">campaign sent 26 minutes ago</span>
          </template>
        </base-material-chart-card>
      </v-col>

      <v-col
        cols="12"
        sm="6"
        lg="3"
      >
        <base-material-stats-card
          color="info"
          icon="mdi-brightness-4"
          title="Astro Calculator"
          value="+245"
          sub-icon="mdi-clock"
          sub-text="Just Updated"
        />
      </v-col>

      <v-col
        cols="12"
        sm="6"
        lg="3"
      >
        <base-material-stats-card
          color="primary"
          icon="mdi-poll"
          title="Website Visits"
          value="75.521"
          sub-icon="mdi-tag"
          sub-text="Tracked from Google Analytics"
        />
      </v-col>

      <v-col
        cols="12"
        sm="6"
        lg="3"
      >
        <base-material-stats-card
          color="success"
          icon="mdi-store"
          title="Revenue"
          value="$ 34,245"
          sub-icon="mdi-calendar"
          sub-text="Last 24 Hours"
        />
      </v-col>

      <v-col
        cols="12"
        sm="6"
        lg="3"
      >
        <base-material-stats-card
          color="orange"
          icon="mdi-sofa"
          title="Bookings"
          value="184"
          sub-icon="mdi-alert"
          sub-icon-color="red"
          sub-text="Get More Space..."
        />
      </v-col>

      <v-col cols="12" md="6">
        <astro-calculator/>
      </v-col>

      <v-col
        cols="12"
        md="6"
      >
        <base-material-card class="px-5 py-3">
          <template v-slot:heading>
            <v-tabs
              v-model="tabs"
              background-color="transparent"
              slider-color="white"
            >
              <span
                class="subheading font-weight-light mx-3"
                style="align-self: center"
              >Tasks:</span>
              <v-tab class="mr-3">
                <v-icon class="mr-2">
                  mdi-bug
                </v-icon>
                Bugs
              </v-tab>
              <v-tab class="mr-3">
                <v-icon class="mr-2">
                  mdi-code-tags
                </v-icon>
                Website
              </v-tab>
              <v-tab>
                <v-icon class="mr-2">
                  mdi-cloud
                </v-icon>
                Server
              </v-tab>
            </v-tabs>
          </template>

          <v-tabs-items
            v-model="tabs"
            class="transparent"
          >
            <v-tab-item
              v-for="n in 3"
              :key="n"
            >
              <v-card-text>
                <template v-for="(task, i) in tasks[tabs]">
                  <v-row
                    :key="i"
                    align="center"
                  >
                    <v-col cols="1">
                      <v-list-item-action>
                        <v-checkbox
                          v-model="task.value"
                          color="secondary"
                        />
                      </v-list-item-action>
                    </v-col>

                    <v-col cols="9">
                      <div
                        class="font-weight-light"
                        v-text="task.text"
                      />
                    </v-col>

                    <v-col
                      cols="2"
                      class="text-right"
                    >
                      <v-icon class="mx-1">
                        mdi-pencil
                      </v-icon>
                      <v-icon
                        color="error"
                        class="mx-1"
                      >
                        mdi-close
                      </v-icon>
                    </v-col>
                  </v-row>
                </template>
              </v-card-text>
            </v-tab-item>
          </v-tabs-items>
        </base-material-card>
      </v-col>
    </v-row>


    <v-row>
      <v-col
        cols="12"
        md="6"
      >
        <v-card class="my-0">
          <v-card-text>
            <base-subheading
              subheading="Navigation Pills"
              text="Horizontal Tabs"
            />

            <base-material-tabs color="warning">
              <v-tab
                v-for="(tab, i) in tabs"
                :key="i"
              >
                {{ tab }}
              </v-tab>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text>
                    <p>
                      Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <p>
                      Dramatically visualize customer directed convergence without revolutionary ROI. Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <div>This is very nice.</div>
                  </v-card-text>
                </v-card>
              </v-tab-item>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text>
                    <p>
                      Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas.
                    </p>

                    <div>
                      Dramatically maintain clicks-and-mortar solutions without functional solutions.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text>
                    <p>
                      Completely synergize resource taxing relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas.
                    </p>

                    <div>
                      Dynamically innovate resource-leveling customer service for state of the art customer service.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>
            </base-material-tabs>
          </v-card-text>
        </v-card>
      </v-col>

      <v-col
        cols="12"
        md="6"
      >
        <v-card class="mt-0">
          <v-card-text>
            <base-subheading
              subheading="Navigation Pills"
              text="Vertical Tabs"
            />

            <base-material-tabs
              color="success"
              vertical
            >
              <v-tab
                v-for="(tab, i) in tabs"
                :key="i"
                class="mb-1"
              >
                {{ tab }}
              </v-tab>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text class="pt-0">
                    <p>
                      Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <p>
                      Dramatically visualize customer directed convergence without revolutionary ROI. Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <div>This is very nice.</div>
                  </v-card-text>
                </v-card>
              </v-tab-item>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text class="pt-0">
                    <p>
                      Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas.
                    </p>

                    <div>
                      Dramatically maintain clicks-and-mortar solutions without functional solutions.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text class="pt-0">
                    <p>
                      Completely synergize resource taxing relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas.
                    </p>

                    <div>
                      Dynamically innovate resource-leveling customer service for state of the art customer service.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>
            </base-material-tabs>
          </v-card-text>
        </v-card>
      </v-col>

      <v-col cols="12" md="6">
        <v-card>
          <v-card-text>
            <base-subheading subheading="Collapsible Accordion" />

            <v-expansion-panels>
              <v-expansion-panel
                v-for="n in 5"
                :key="n"
              >
                <v-expansion-panel-header>
                  Collapsible Group Item #{{ n }}
                </v-expansion-panel-header>

                <v-expansion-panel-content>
                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-card-text>
        </v-card>
      </v-col>

      <v-col
        class="mb-12"
        cols="12"
        md="6"
      >
        <v-card>
          <v-card-text>
            <base-subheading
              subheading="Navigation Pills"
              text="Vertical Tabs"
            />

            <base-material-tabs
              color="success"
              icons-and-text
              vertical
            >
              <v-tab
                v-for="(tab, i) in tabs2"
                :key="i"
                class="mb-5"
              >
                {{ tab.text }}
                <v-icon v-text="tab.icon" />
              </v-tab>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text class="pt-0">
                    <p>
                      Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <p>
                      Dramatically visualize customer directed convergence without revolutionary ROI. Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </p>

                    <div>
                      Dramatically visualize customer directed convergence without revolutionary ROI. Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>

              <v-tab-item>
                <v-card
                  flat
                  class="my-0"
                >
                  <v-card-text class="pt-0">
                    <p>
                      Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas.
                    </p>

                    <div>
                      Dramatically maintain clicks-and-mortar solutions without functional solutions.
                    </div>
                  </v-card-text>
                </v-card>
              </v-tab-item>
            </base-material-tabs>
          </v-card-text>
        </v-card>
      </v-col>

      <v-col
        class="mx-auto"
        cols="12"
        md="8"
      >
        <div class="text-center headline font-weight-light mb-12 pl-0">
          Page Subcategories
        </div>

        <base-material-tabs
          v-model="tab"
          background-color="transparent"
          centered
          color="warning"
          icons-and-text
        >
          <v-tab
            v-for="(tab, i) in tabs3"
            :key="i"
          >
            {{ tab.text }}
            <v-icon v-text="tab.icon" />
          </v-tab>

          <v-tabs-items
            v-model="tab"
            class="pt-12 transparent"
          >
            <v-tab-item>
              <v-card class="mt-0 px-5">
                <v-card-text>
                  <base-subheading subheading="Description about product">
                    <p class="grey--text body-2 font-weight-light">
                      More Information here
                    </p>
                  </base-subheading>

                  <p>
                    Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                  </p>

                  <div>
                    Dramatically visualize customer directed convergence without revolutionary ROI. Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits.
                  </div>
                </v-card-text>
              </v-card>
            </v-tab-item>

            <v-tab-item>
              <v-card class="mt-0 px-5">
                <v-card-text>
                  <base-subheading subheading="Location of the product product">
                    <p class="grey--text body-2 font-weight-light">
                      More Information here
                    </p>
                  </base-subheading>

                  <p>
                    Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas.
                  </p>

                  <div>
                    Dramatically maintain clicks-and-mortar solutions without functional solutions
                  </div>
                </v-card-text>
              </v-card>
            </v-tab-item>

            <v-tab-item>
              <v-card class="mt-0 px-5">
                <v-card-text>
                  <base-subheading subheading="Legal info of the product product">
                    <p class="grey--text body-2 font-weight-light">
                      More Information here
                    </p>
                  </base-subheading>

                  <p>
                    Completely synergize resource taxing relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas.
                  </p>

                  <div>
                    Dynamically innovate resource-leveling customer service for state of the art customer service.
                  </div>
                </v-card-text>
              </v-card>
            </v-tab-item>

            <v-tab-item>
              <v-card class="mt-0 px-5">
                <v-card-text>
                  <base-subheading heading="Help center">
                    <p class="grey--text body-2 font-weight-light">
                      More Information here
                    </p>
                  </base-subheading>

                  <p>
                    From the seamless transition of glass and metal to the streamlined profile, every detail was carefully considered to enhance your experience. So while its display is larger, the phone feels just right.
                  </p>

                  <div>
                    Another Text. The first thing you notice when you hold the phone is how great it feels in your hand. The cover glass curves down around the sides to meet the anodized aluminum enclosure in a remarkable, simplified design.
                  </div>
                </v-card-text>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </base-material-tabs>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  import AstroCalculator from "./items/AstroCalculator";
  export default {
    name: 'DashboardDashboard',
    components: {AstroCalculator},
    data () {
      return {
        tab: 0,
        tabs: [
          'Profile',
          'Settings',
          'Options',
        ],
        tabs2: [
          {
            text: 'Home',
            icon: 'mdi-view-dashboard',
          },
          {
            text: 'Settings',
            icon: 'mdi-clock-outline',
          },
        ],
        tabs3: [
          {
            text: 'Description',
            icon: 'mdi-information',
          },
          {
            text: 'Location',
            icon: 'mdi-map-marker',
          },
          {
            text: 'Legal Info',
            icon: 'mdi-gavel',
          },
          {
            text: 'Help Center',
            icon: 'mdi-help-circle-outline',
          },
        ],
        dailySalesChart: {
          data: {
            labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
            series: [
              [12, 17, 7, 17, 23, 18, 38],
            ],
          },
          options: {
            lineSmooth: this.$chartist.Interpolation.cardinal({
              tension: 0,
            }),
            low: 0,
            high: 50, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
            chartPadding: {
              top: 0,
              right: 0,
              bottom: 0,
              left: 0,
            },
          },

        },
        dataCompletedTasksChart: {
          data: {
            labels: ['12am', '3pm', '6pm', '9pm', '12pm', '3am', '6am', '9am'],
            series: [
              [230, 750, 450, 300, 280, 240, 200, 190],
            ],
          },
          options: {
            lineSmooth: this.$chartist.Interpolation.cardinal({
              tension: 0,
            }),
            low: 0,
            high: 1000, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
            chartPadding: {
              top: 0,
              right: 0,
              bottom: 0,
              left: 0,
            },
          },
        },
        emailsSubscriptionChart: {
          data: {
            labels: ['Ja', 'Fe', 'Ma', 'Ap', 'Mai', 'Ju', 'Jul', 'Au', 'Se', 'Oc', 'No', 'De'],
            series: [
              [542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895],

            ],
          },
          options: {
            axisX: {
              showGrid: false,
            },
            low: 0,
            high: 1000,
            chartPadding: {
              top: 0,
              right: 5,
              bottom: 0,
              left: 0,
            },
          },
          responsiveOptions: [
            ['screen and (max-width: 640px)', {
              seriesBarDistance: 5,
              axisX: {
                labelInterpolationFnc: function (value) {
                  return value[0]
                },
              },
            }],
          ],
        },
        headers: [
          {
            sortable: false,
            text: 'ID',
            value: 'id',
          },
          {
            sortable: false,
            text: 'Name',
            value: 'name',
          },
          {
            sortable: false,
            text: 'Salary',
            value: 'salary',
            align: 'right',
          },
          {
            sortable: false,
            text: 'Country',
            value: 'country',
            align: 'right',
          },
          {
            sortable: false,
            text: 'City',
            value: 'city',
            align: 'right',
          },
        ],
        items: [
          {
            id: 1,
            name: 'Dakota Rice',
            country: 'Niger',
            city: 'Oud-Tunrhout',
            salary: '$35,738',
          },
          {
            id: 2,
            name: 'Minerva Hooper',
            country: 'Curaçao',
            city: 'Sinaai-Waas',
            salary: '$23,738',
          },
          {
            id: 3,
            name: 'Sage Rodriguez',
            country: 'Netherlands',
            city: 'Overland Park',
            salary: '$56,142',
          },
          {
            id: 4,
            name: 'Philip Chanley',
            country: 'Korea, South',
            city: 'Gloucester',
            salary: '$38,735',
          },
          {
            id: 5,
            name: 'Doris Greene',
            country: 'Malawi',
            city: 'Feldkirchen in Kārnten',
            salary: '$63,542',
          },
        ],
        tabs: 0,
        tasks: {
          0: [
            {
              text: 'Sign contract for "What are conference organizers afraid of?"',
              value: true,
            },
            {
              text: 'Lines From Great Russian Literature? Or E-mails From My Boss?',
              value: false,
            },
            {
              text: 'Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit',
              value: false,
            },
            {
              text: 'Create 4 Invisible User Experiences you Never Knew About',
              value: true,
            },
          ],
          1: [
            {
              text: 'Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit',
              value: true,
            },
            {
              text: 'Sign contract for "What are conference organizers afraid of?"',
              value: false,
            },
          ],
          2: [
            {
              text: 'Lines From Great Russian Literature? Or E-mails From My Boss?',
              value: false,
            },
            {
              text: 'Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit',
              value: true,
            },
            {
              text: 'Sign contract for "What are conference organizers afraid of?"',
              value: true,
            },
          ],
        },
        list: {
          0: false,
          1: false,
          2: false,
        },
      }
    },

    methods: {
      complete (index) {
        this.list[index] = !this.list[index]
      },
    },
  }
</script>
