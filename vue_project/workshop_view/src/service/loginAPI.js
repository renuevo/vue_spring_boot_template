import axios from 'axios'

const getUserInfo = (userName, password) => {
  return axios.post('//localhost:8080/login', {
    params: {
      'userName': userName,
      'password': password
    }
  })
};

export default {
  async login (userName, password) {
    try {
      const getUserInfoPromise = await getUserInfo(userName, password);
      if (getUserInfoPromise.data.length === 0) return 'noAuth'; // 로그인 결과에 따른 분기 처리를 해준다
      return getUserInfoPromise
    } catch (err) {
      console.error(err)
    }
  }
}
