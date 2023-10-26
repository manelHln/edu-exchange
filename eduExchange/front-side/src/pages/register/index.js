

export default function LoginPage() {
    return (
         <>
         
            <div className="flex inline-block align-middle flex-1 flex-col justify-center px-6 py-12 lg:px-8 ">
            <div className=" ">
              
      
              <div className=" sm:mx-auto sm:w-full sm:max-w-sm shadow-lg px-10  py-8 rounded-3xl">
              <div className="sm:mx-auto sm:w-full sm:max-w-sm ">
                <h2 className=" text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
                 Student Register
                </h2>
              <p className="px-8 mt-3 mb-5 text-sm font-[400] text-center">Welcome, Enter your details to register</p>

              </div>
                <form className="space-y-6" action="#" method="POST">
                <div>
                  <div className="mt-2">
                      <input
                        id="firstName"
                        name="firstName"
                        type="text"
                        autoComplete="firstName"
                        placeholder="Enter your first name"
                        required
                        className="block w-full rounded-md border-0 py-1.5 px-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 border-none focus:ring-1 focus:outline-login-orange sm:text-sm sm:leading-6"
                      />
                    </div> 
                    </div> 
                <div>
                  <div className="mt-2">
                      <input
                        id="lastName"
                        name="lastName"
                        type="text"
                        autoComplete="lastName"
                        placeholder="Enter your last name"
                        required
                        className="block w-full rounded-md border-0 py-1.5 px-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 border-none focus:ring-1 focus:outline-login-orange sm:text-sm sm:leading-6"
                      />
                    </div> 
                    </div> 

                  <div>
             
                    <div className="mt-2">
                      <input
                        id="email"
                        name="email"
                        type="email"
                        autoComplete="email"
                        placeholder="Enter Email / Phone No"
                        required
                        className="block w-full rounded-md border-0 py-1.5 px-3 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 border-none focus:ring-1 focus:outline-login-orange sm:text-sm sm:leading-6"
                      />
                    </div>
                  </div>
      
                  <div>
                    
                    <div className="mt-2">
                      <input
                        id="password"
                        name="password"
                        type="password"
                        placeholder="Passcode"
                        autoComplete="current-password"
                        required
                        className="block w-full rounded-md px-3  border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-1 focus:outline-login-orange sm:text-sm sm:leading-6"
                      />
                    </div>
                  <a href="#" className=" mt-3 mb-5 text-[11px] ">
                  You forget your password?
                  </a>
                    
                  </div>
      
                  <div>
                 
                    <button
                      type="submit"
                      className="flex w-full justify-center fursor-pointer py-2 px-6 rounded-md bg-login-orange text-sm font-black"
                    >
                      Sign in
                    </button>
              
                  </div>
                </form>
      
                <p className="mt-5 text-center text-sm text-gray-500">
                  Already have account?{' '}
                  <a href="#" className="font-semibold text-black-500 hover:text-slate-900">
                    Connect now
                  </a>
                </p>
              </div>
              </div>
            </div>
     
            </>
    );
}