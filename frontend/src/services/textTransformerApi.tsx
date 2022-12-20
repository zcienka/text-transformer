import {createApi} from "@reduxjs/toolkit/query/react"
import {fetchBaseQuery} from "@reduxjs/toolkit/dist/query/react"
import {Request, Response} from "../types"

export const textTransformerApi = createApi({
    reducerPath: "textTransformerApi",
    baseQuery: fetchBaseQuery({
            baseUrl: "http://localhost:8080/api"
        }
    ),
    endpoints: (builder) => ({
        sendText: builder.mutation<Response, Request>({
            query: (body) => ({
                url: `/${body.transformation}`,
                method: "POST",
                body: {text: body.text}
            }),
        }),
    })
})

export const {useSendTextMutation} = textTransformerApi