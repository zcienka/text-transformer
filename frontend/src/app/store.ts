import {configureStore} from "@reduxjs/toolkit"
import {setupListeners} from "@reduxjs/toolkit/query"
import {textTransformerApi} from "../services/textTransformerApi"

const store = configureStore({
    reducer: {
        [textTransformerApi.reducerPath]: textTransformerApi.reducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(textTransformerApi.middleware)
})

setupListeners(store.dispatch)

export default store