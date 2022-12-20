module.exports = {
    content: ["./src/**/*.{js,jsx,ts,tsx}",
        'node_modules/flowbite-react/**/*.{js,jsx,ts,tsx}'],
    theme: {
        fontFamily: {
            'roboto': ['Roboto', 'sans-serif'],
        },
        extend: {
            spacing: {
                '128': '32rem',
                '160': '40rem',
            }
        }
    },
    plugins: ["tailwindcss, autoprefixer", "flowbite/plugin"],
}