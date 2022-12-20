import React, {useEffect, useState} from "react"
import {ReactComponent as ArrowRight} from "../icons/ArrowRight.svg"
import {ReactComponent as ExclamationMark} from "../icons/ExclamationMark.svg"
import {useSendTextMutation} from "../services/textTransformerApi"
import {Request} from "../types"

const Home: React.FC = () => {
    const [text, setText] = useState<string>("")
    const [transformation, setTransformation] = useState<string>("capitalize")
    const [transformedText, setTransformedText] = useState<string>("")
    const [textLengthError, setTextLengthError] = useState<boolean>(false)
    const [textEmptyError, setTextEmptyError] = useState<boolean>(false)

    const [sendText,
        {
            data: result,
            isSuccess: isTextSuccess,
            isLoading: isTextLoading
        }
    ] = useSendTextMutation()

    const sendRequest = async () => {
        if (text.length <= 400 && text !== "") {
            const request: Request = {
                text: text,
                transformation: transformation,
            }
            await sendText(request)
        } else if (text.length > 400) {
            setTextLengthError(true)
        } else if (text === ""){
            setTextEmptyError(true)
        }
    }

    useEffect(() => {
        if (isTextSuccess && result !== undefined) {
            setTransformedText(result.text)
        }
    }, [isTextSuccess, result])

    return <div className={"bg-zinc-100 flex items-center justify-center h-screen flex-col"}>
        <div className={"border border-stone-200 p-10 rounded-3xl bg-white"}>
            <h1 className={"md:text-5xl font-bold pb-6 text-3xl flex justify-center"}>Text transformer</h1>

            <div className={"pb-6"}>
                <div className={"md:w-96 w-64"}>
                    <h2 className={"md:text-xl text-lg pb-2"}>Transformation</h2>
                </div>
                <select className={"px-5 md:w-96 w-64 border-2 border-zinc-300 py-3 rounded-3xl text-lg bg-white h-14"}
                        onChange={(e) => setTransformation(e.target.value)}>
                    <option className={"px-8"} value={"capitalize"}>
                        Capitalization
                    </option>
                    <option className={"px-8"} value={"uppercase"}>
                        Uppercase conversion
                    </option>
                    <option className={"px-8"} value={"lowercase"}>
                        Lowercase conversion
                    </option>
                    <option className={"px-8"} value={"expand-abbreviation"}>
                        Abbreviation expansion
                    </option>
                    <option className={"px-8"} value={"latex"}>
                        Latex conversion
                    </option>
                    <option className={"px-8"} value={"eliminate-duplicates"}>
                        Duplicates elimination
                    </option>
                    <option className={"px-8"} value={"inverse"}>
                        Inversion
                    </option>
                    <option className={"px-8"} value={"words-to-abbreviations"}>
                        Abbreviation conversion
                    </option>

                </select>
            </div>

            <div className={"md:w-96 w-64"}>
                <h2 className={"md:text-xl text-lg pb-2"}>Text</h2>
            </div>
            <div className={"flex flex-row-reverse relative md:w-96 w-64 h-14"}>
                <button className={"absolute w-12 h-12 top-1 pr-2"} onClick={() => sendRequest()}>
                    <ArrowRight
                        className={"rounded-3xl hover:bg-blue-400 bg-blue-500 text-white p-2 w-10 h-10"}/>
                </button>

                <input
                    className={`w-full py-3 px-6 rounded-3xl border-2 pr-16 justify-center text-lg  ${textLengthError || textEmptyError ? "border-red-700" : "border-zinc-300"}`}
                    onChange={(e) => {
                        setText(e.target.value)
                        setTextLengthError(false)
                        setTextEmptyError(false)
                    }}/>
            </div>

            <div className={"h-6 flex w-full text-red-700 text-xs"}>
                <div className={`flex mt-2 items-center ${textLengthError ?
                    "visible w-full" : "invisible absolute"}`}>
                    <ExclamationMark className={"h-5 mr-1"}/>
                    <p>Text cannot be longer than 400 characters</p>
                </div>

                <div className={`flex mt-2 items-center ${textEmptyError ?
                    "visible w-full " : "invisible absolute"}`}>
                    <ExclamationMark className={"h-5 mr-1"}/>
                    <p>Text cannot be empty</p>
                </div>
            </div>

            <div className={"md:w-96 w-64"}>
                <h2 className={"md:text-xl text-lg pb-2"}>Transformed text</h2>
            </div>
            <p className={`max-w-64 md:max-w-96 md:w-96 w-64 break-words py-3 px-6 border-2 border-zinc-300 rounded-3xl text-lg  
            ${transformedText === "" ? "h-14" : "min-h-14"}`}>
                {transformedText}
            </p>
        </div>
    </div>
}

export default Home