import Link from "next/link";
import { useState } from "react";
import { montserrat, dm_sans } from "@/utils/fonts";
import InputWithLabel from "@/components/InputWithLabel";
import Button from "@/components/Button";
import Icon from "@/components/Icon";

const inputClassname =
  "block w-full rounded-md border-0 py-1.5 px-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 border-none focus:ring-1 focus:outline-custom-orange sm:text-sm sm:leading-6";

const handleFormSubmit = (e) => {
  e.preventDefault();
  const formdata = new FormData(e.target);
  const jsonData= {}
  for(let value of formdata.entries()){
    Object.assign(jsonData, {[value[0]]: value[1]})
  }
};

export default function RegisterPage() {
  const [passwordView, setPasswordView] = useState(true);
  return (
    <>
      <div className="flex align-middle flex-1 flex-col justify-center px-6 py-12 lg:px-8 bg-custom-orange w-screen h-screen">
        <div className=" ">
          <div className=" sm:mx-auto sm:w-full sm:max-w-sm shadow-lg px-10  py-8 rounded-xl bg-white">
            <div className="sm:mx-auto sm:w-full sm:max-w-sm ">
              <h2
                className={`text-center text-3xl font-bold leading-9 tracking-tight text-gray-900 ${dm_sans.className}`}
              >
                Registration
              </h2>
              <p
                className={`px-8 mt-3 mb-5 text-sm text-center font-[500] ${montserrat.className}`}
              >
                Fill in your details to get started!!
              </p>
            </div>
            <form className="space-y-6" onSubmit={handleFormSubmit}>
              <InputWithLabel
                id="fullname"
                type="text"
                label="Fullname"
                className={inputClassname}
                name="fullname"
                htmlFor="fullname"
                placeholder="John Doe"
                required
              />

              <InputWithLabel
                id="email"
                type="email"
                label="Your email"
                className={inputClassname}
                autoComplete="email"
                name="email"
                htmlFor="email"
                placeholder="email@company.com"
                required
              />
              <InputWithLabel
                id="pseudo"
                type="text"
                label="Your pseudo"
                className={inputClassname}
                name="pseudo"
                htmlFor="pseudo"
                placeholder="_datboii.mowgli"
                required
              />

              <div>
                <label
                  htmlFor="password"
                  className="block mb-2 text-sm font-medium text-gray-900 "
                >
                  Your password
                </label>
                <div className="mt-2 relative">
                  <div className="absolute top-2/4 right-1 grid h-5 w-5 -translate-y-2/4 place-items-center text-blue-gray-500 cursor-pointer">
                    <Icon
                      name={passwordView ? "eye" : "eye-off"}
                      size={16}
                      onClick={() => {
                        setPasswordView((prev) => !prev);
                      }}
                    />
                  </div>
                  <input
                    id="password"
                    name="password"
                    type={passwordView ? "password" : "text"}
                    autoComplete="current-password"
                    required
                    className="block w-full rounded-md px-3  border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:outline-custom-orange sm:text-sm sm:leading-6"
                  />
                </div>
                <Link href="#" className=" mt-3 mb-5 text-[11px] ">
                  Forgot your password?
                </Link>
              </div>

              <Button
                text="Register"
                className="flex w-full justify-center fursor-pointer py-2 px-6 rounded-md bg-custom-orange text-sm font-black text-white"
                type="submit"
              />
            </form>

            <p className="mt-5 text-center text-sm text-gray-500">
              Already have account?{" "}
              <Link
                href="/login"
                className="font-semibold text-black-500 hover:text-slate-900"
              >
                Sign in
              </Link>
            </p>
          </div>
        </div>
      </div>
    </>
  );
}
