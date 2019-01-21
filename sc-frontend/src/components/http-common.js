import axios from 'axios'
axios.defaults.headers.post['Content-Type'] = 'application/json;odata=verbose;charset=utf-8';
// axios.defaults.data.post['Content-Type'] = 'application/json;odata=verbose;charset=utf-8';

export const AXIOS = axios.create({
  baseURL: 'http://localhost:8080/',
headers: {
  Authorization: 'Bearer {LOGIN_TOKEN}'

}
})
