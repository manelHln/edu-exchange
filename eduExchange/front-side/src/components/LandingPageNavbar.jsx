import React from "react";
import Button from "./Button";
import Link from "next/link";

const LandingPageNavbar = () => {
  return (
    <div className="hidden sticky top-0 sm:flex justify-between items-center py-4 px-40 shadow-sm bg-white z-10">
      <div>edu.Exchange</div>
      <ul className="flex align-middle gap-8 text-sm">
        <li>
          <Link href={"/"}>Demos</Link>
        </li>
        <li>
          <Link href={"/"}>About</Link>
        </li>
        <li>
          <Link href={"/"}>Blog</Link>
        </li>
        <li>
          <Link href={"/"}>Pages</Link>
        </li>
      </ul>
      <div className="flex gap-4 align-middle">
        <Button
          text={"Login"}
          className="cursor-pointer hover:underline text-sm"
          to="/login"
        />
        <Button
          text={"Get started Free"}
          className="cursor-pointer py-2 px-4 rounded-md text-white bg-custom-orange text-sm"
        />
      </div>
    </div>
  );
};

export default LandingPageNavbar;
