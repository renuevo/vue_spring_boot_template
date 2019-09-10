import {USER_NAME, IS_AUTH, ERROR_STATE} from './mutation_types'
import api from '../service/loginAPI'

let setUSER_NAME = ({commit}, data) => {
  commit(USER_NAME, data)
}

let setErrorState = ({commit}, data) => {
  commit(ERROR_STATE, data)
}

let setIsAuth = ({commit}, data) => {
  commit(IS_AUTH, data)
}

// 백엔드에서 반환한 결과값을 가지고 로그인 성공 실패 여부를 vuex에 넣어준다.
let processResponse = (store, loginResponse) => {
  switch (loginResponse) {
    case 'noAuth':
      setErrorState(store, 'Wrong ID or Password');
      setIsAuth(store, false);
      break;
    default:
      setUSER_NAME(store, loginResponse.test);
      setErrorState(store, '');
      setIsAuth(store, true)
  }
}


export default {
  async login(store, {userId, password}) {
    let loginResponse = await api.login(userId, password);
    processResponse(store, loginResponse);
    return store.getters.getIsAuth
  }
}
