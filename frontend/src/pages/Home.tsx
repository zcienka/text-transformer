import React, {useEffect, useState} from "react"
import {ReactComponent as ArrowRight} from "../icons/ArrowRight.svg"
import {ReactComponent as ExclamationMark} from "../icons/ExclamationMark.svg"
import {useSendTextMutation} from "../services/textTransformerApi"
import {Request} from "../types"

const Home: React.FC = () => {
    const [text, setText] = useState<string>("")
    const [transformation, setTransformation] = useState<string[]>([])
    const [transformedText, setTransformedText] = useState<string>("")
    const [textLengthError, setTextLengthError] = useState<boolean>(false)
    const [textEmptyError, setTextEmptyError] = useState<boolean>(false)

    const [sendText,
        {
            data: result,
            isSuccess: isTextSuccess,
        }
    ] = useSendTextMutation()

    const sendRequest = async () => {
        if (text.length <= 400 && text !== "") {
            const request: Request = {
                text: text,
                transformation: transformation.join(" "),
            }
            await sendText(request)
        } else if (text.length > 400) {
            setTextLengthError(true)
        } else if (text === "") {
            setTextEmptyError(true)
        }
    }
console.log(result)
    const updateTransformations = (e: React.ChangeEvent<HTMLInputElement>) => {
        if (e.target.checked) {
            setTransformation((values: string[]) => [...values, e.target.value])
        } else {
            setTransformation((values: string[]) => values.filter((value) => value !== e.target.value))
        }
    }
    console.log({transformation})

    useEffect(() => {
        if (isTextSuccess && result !== undefined) {
            setTransformedText(result.text)
        }
    }, [isTextSuccess, result])

    return <div className={"bg-blue-50 flex items-center justify-center h-screen flex-col"}>
        <div className={"border border-stone-200 p-10 rounded-3xl bg-white"}>
            <h1 className={"md:text-5xl font-bold pb-6 text-3xl flex justify-center"}>Text transformer</h1>

            <div className={"pb-6"}>
                <div className={"md:w-96 w-64"}>
                    <h2 className={"md:text-xl text-lg pb-2"}>Transformations</h2>
                </div>
                <div className={"flex flex-col"}>
                    <div className={"flex"}>
                        <input type="checkbox" id="capitalize" value="capitalize" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="capitalize">
                            Capitalization
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="uppercase" value="uppercase" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="uppercase">
                            Uppercase conversion
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="lowercase" value="lowercase" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="lowercase">
                            Lowercase conversion
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="expand-abbreviation" value="expand-abbreviation" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="expand-abbreviation">
                            Abbreviation expansion
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="latex" value="latex" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="latex">
                            Latex conversion
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="eliminate-duplicates" value="eliminate-duplicates" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="eliminate-duplicates">
                            Duplicates elimination
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="inverse" value="inverse" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="inverse">
                            Inversion
                        </label>
                    </div>

                    <div className={"flex"}>
                        <input type="checkbox" id="words-to-abbreviations" value="words-to-abbreviations" onChange={event => updateTransformations(event)}/>
                        <label htmlFor="words-to-abbreviations">
                            Abbreviation conversion
                        </label>
                    </div>
                </div>
            </div>

            <div className={"md:w-96 w-64"}>
                <h2 className={"md:text-xl text-lg mb-2 "}>Text</h2>
            </div>
            <div className={"flex flex-row-reverse relative md:w-96 w-64 h-14"}>
                <button className={"absolute w-14 h-14 pr-4"} onClick={() => sendRequest()}>
                    <ArrowRight
                        className={"rounded-3xl hover:bg-blue-400 bg-blue-500 text-white p-2 w-10 h-10"}/>
                </button>

                <input
                    className={`w-full py-3 px-6 rounded-3xl border pr-16 justify-center text-lg  ${textLengthError || textEmptyError ? "border-red-700" : "border-zinc-300"}`}
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
            <p className={`max-w-64 md:max-w-96 md:w-96 w-64 break-words py-3 px-6 border border-zinc-300 rounded-3xl text-lg
            ${transformedText === "" ? "h-14" : "min-h-14"}`}>
                {transformedText}
            </p>
        </div>
    </div>
}

export default Home