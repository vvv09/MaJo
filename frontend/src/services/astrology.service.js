import axios from 'axios'
import authHeader from './auth-header';


const BACK_API_URL = 'http://localhost:8999'
const SUBJECT_API_URL = `${BACK_API_URL}/api/astrology`

class EntryService {

  retrieveForDayPlace(date, lon, lan) {
    return axios.get(`${SUBJECT_API_URL}?date=${date}&lon=${lon}&lan=${lan}`, { headers: authHeader() });
  }

}

export default new EntryService()
