"use client";
import React, { useState } from "react";
import Button from "./Button";
import Link from "next/link";
import { MenuSquare } from "lucide-react";
import { XIcon } from "lucide-react";

const LandingPageNavbar = () => {
  const [toggleMobileNav, setToggleMobileNav] = useState(false);
  return (
    <div className="sticky top-0 flex justify-between items-center sm:py-4 sm:px-40 shadow-sm bg-white w-full z-10">
      <div>edu.Exchange</div>
      <ul className="hidden sm:flex items-center gap-8 text-sm">
        {["Demos", "About", "Blog", "Pages"].map((e, i) => (
          <li key={`${e}-${i}`}>
            <Link href={"/"}>{e}</Link>
          </li>
        ))}
      </ul>
      <div className="hidden sm:flex gap-4 items-center">
        <Button
          text={"Login"}
          className="cursor-pointer hover:underline text-sm"
          to="/login"
        />
        <Button
          text={"Get started Now"}
          className="cursor-pointer py-2 px-4 rounded-md text-white bg-custom-orange text-sm"
        />
      </div>

      <div className="flex sm:hidden justify-center items-center bg-custom-orange w-9 h-9 rounded-[50%] relative">
        <MenuSquare
          className="cursor-pointer text-white w-[70%] height-[70%]"
          onClick={() => setToggleMobileNav(true)}
        />
        {toggleMobileNav && (
          <div className="fixed bg-custom-orange top-0 bottom-0 right-0 z-10 p-4 w-4/5 h-screen flex flex-col justify-end items-end shadow-sm">
            <XIcon className="cursor-pointer w-9 h-9 text-white my-2 mx-4" onClick={() => setToggleMobileNav(false)} />
            <ul className="flex sm:hidden flex-col justify-start items-start w-full h-full gap-2 text-sm">
              {["Demos", "About", "Blog", "Pages"].map((e, i) => (
                <li key={`${e}-${i}`}>
                  <Link href={"/"}>{e}</Link>
                </li>
              ))}
            </ul>
          </div>
        )}
      </div>
    </div>
  );
};

export default LandingPageNavbar;
