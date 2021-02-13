import axios from 'axios'
import authHeader from './auth-header';


const BACK_API_URL = 'http://localhost:8999'
const SUBJECT_API_URL = `${BACK_API_URL}/api/entry`

class EntryService {

  retrieveAll() {
    return axios.get(`${SUBJECT_API_URL}`, { headers: authHeader() });
  }

  retrieveForToday(astrology) {
    var sr = astrology.sunrise
    var ss = astrology.sunset
    var m = astrology.moonPhase
    return axios.get(`${SUBJECT_API_URL}/today?sr=${sr}&ss=${ss}&m=${m}`, { headers: authHeader() });
  }

  retrieveById(id) {
    return axios.get(`${SUBJECT_API_URL}/${id}`, { headers: authHeader() });
  }

  delete(id) {
    return axios.delete(`${SUBJECT_API_URL}/${id}`, { headers: authHeader() });
  }

  update(entry) {
    console.log("updating")
    const id = entry.id
    return axios.put(`${SUBJECT_API_URL}/${id}`, entry, { headers: authHeader() });
  }

  create(entry) {
    return axios.post(`${SUBJECT_API_URL}`, entry, { headers: authHeader() });
  }

}

export default new EntryService()
