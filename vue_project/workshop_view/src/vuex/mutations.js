import * as types from './mutation_types'

export default {
  [types.USER_NAME] (state, userName) {
    state.userName = userName
  },
  [types.ERROR_STATE] (state, errorState) {
    state.errorState = errorState
  },
  [types.IS_AUTH] (state, isAuth) {
    state.isAuth = isAuth
  }
}
