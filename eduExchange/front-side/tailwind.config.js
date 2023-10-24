/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  theme: {
    extend: {
      backgroundImage: {
        'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
        'gradient-conic':
          'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      },
      colors:{
        'black-primary': "#1B1C20",
        "light-primary": "#383A47",
        "bg-light": "#F8F8FA",
        "custom-orange": "#FB8E0B",
        "login-orange" : "#fec887"
      },
      fontFamily: {
        "dm-sans": ["var(--font-dm_sans)"],
        "montserrat": ["var(--font-montserrat)"]
      }
    },
  },
  plugins: [],
}
