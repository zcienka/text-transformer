import React from "react"
import {ReactComponent as ArrowRight} from "../icons/ArrowRight.svg";

const Home: React.FC = () => {

    return <div className={"flex items-center justify-center h-screen flex-col"}>
        <h1 className={"text-5xl font-bold pb-6"}>Text transformer</h1>

        <div className={"pb-2"}>
            <div className={"w-96"}>
                <h2 className={"text-xl pb-2"}>Transformation</h2>
            </div>
            <select className={"px-5 w-96 border-2 border-zinc-300 py-3 rounded-3xl text-lg"}>
                {/*<option selected className={"px-8"} value={"default"}>*/}
                {/*    Select transformation*/}
                {/*</option>*/}
                <option className={"px-8"} value={"capitalize"}>
                    Capitalize
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Inverse
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Eliminate duplicates
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Convert to lowercase
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Reverse
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Convert to abbreviations
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Expand abbreviations
                </option>
                <option className={"px-8"} value={"inverse"}>
                    Convert to format supported in Latex
                </option>
            </select>
        </div>

        <div className={"pb-2"}>
            <div className={"w-96"}>
                <h2 className={"text-xl pb-2"}>Enter text</h2>
            </div>
            <div className={"flex flex-row-reverse relative w-96"}>
                <button className={"absolute w-12 h-12 top-1  pr-2"}>
                    <ArrowRight className={"rounded-3xl hover:bg-blue-400 bg-blue-500 text-white p-2"}/>
                </button>

                <input className={"w-full py-3 px-6 rounded-3xl text-xl border-2 border-zinc-300 pr-16 justify-center text-lg"}
                       />
            </div>
        </div>
        <div className={"w-96"}>
            <h2 className={"text-xl pb-2"}>Transformed text</h2>
        </div>
        <p className={"w-96 py-3 px-6 border-2 border-zinc-300 rounded-3xl text-lg"}>Capitalize </p>
    </div>
}

export default Home