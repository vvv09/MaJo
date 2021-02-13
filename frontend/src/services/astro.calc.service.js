import suncalc from 'suncalc'

// для питера с сайта
// https://www.gps-latitude-longitude.com/gps-coordinates-of-Sankt-Ptrburg
const latitude = 59.9342802
const longitude = 30.3350986

class AstroCalcService {
  getForToday() {
    var result1 = suncalc.getTimes( new Date(), latitude, longitude, 0)
    var result2 = suncalc.getMoonIllumination(new Date())

    var sunriseHour = result1.sunrise.getHours() + ''
    var sunriseMinutes = result1.sunrise.getMinutes() + ''
    var sunsetHour = result1.sunset.getHours() + ''
    var sunsetMinutes = result1.sunset.getMinutes() + ''

    if (sunriseHour.length == 1) sunriseHour = '0' + sunriseHour
    if (sunriseMinutes.length == 1) sunriseMinutes = '0' + sunriseMinutes
    if (sunsetHour.length == 1) sunsetHour = '0' + sunsetHour
    if (sunsetMinutes.length == 1) sunsetMinutes = '0' + sunsetMinutes

    var result = {
      sunrise: sunriseHour + ':' + sunriseMinutes,
      sunset: sunsetHour + ':' + sunsetMinutes,
      moonPhase: result2.phase.toFixed(2),
    }

    return result
  }

  // getForToday() {
  //   for (var i = 1;
  //   i < 12;
  //   i++)  {
  //     date = new Date("2021-02-0" + i)
  //     var result1 = suncalc.getTimes(/*Date*/ date, /*Number*/ latitude, /*Number*/ longitude, /*Number (default=0)*/ 0)
  //     var result2 = suncalc.getMoonIllumination(/*Date*/ date)
  //
  //     var sunriseHour = result1.sunrise.getHours() + ''
  //     var sunriseMinutes = result1.sunrise.getMinutes() + ''
  //     var sunsetHour = result1.sunset.getHours() + ''
  //     var sunsetMinutes = result1.sunset.getMinutes() + ''
  //
  //     if (sunriseHour.length == 1) sunriseHour = '0' + sunriseHour
  //     if (sunriseMinutes.length == 1) sunriseMinutes = '0' + sunriseMinutes
  //     if (sunsetHour.length == 1) sunsetHour = '0' + sunsetHour
  //     if (sunsetMinutes.length == 1) sunsetMinutes = '0' + sunsetMinutes
  //
  //     var result = {
  //       sunrise: sunriseHour + ':' + sunriseMinutes,
  //       sunset: sunsetHour + ':' + sunsetMinutes,
  //       moonPhase: result2.phase.toFixed(2),
  //     }
  //
  //     console.log(date)
  //     console.log("sunrise ", result.sunrise)
  //     console.log("sunset ", result.sunset)
  //     console.log("moonPhase ", result.moonPhase)
  //   }
  //   return {}
  // }

}

export default new AstroCalcService()
