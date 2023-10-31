import React from "react";
import Image from "next/image";
import { girl_2 } from "@/assets/images";
import InputWithIcon from "./InputWithIcon";
import { Avatar, AvatarFallback, AvatarImage } from "./ui/avatar";

const ChatHeader = () => {
  return (
    <div className="sticky top-0 bg-gray-200 z-10 border-b border-b-slate-400 flex justify-between items-center w-full p-4">
      <div>
        <div className="flex gap-4">
          {/* <div>
            <Image src={girl_2} alt="User avatar" width={40} height={40} />
          </div> */}
          <Avatar>
            <AvatarImage src={girl_2}></AvatarImage>
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
          <div className="flex items-center">
            <div className="text-sm font-semibold">Michael</div>
          </div>
        </div>
      </div>
      <form>
        <InputWithIcon
          name={"search"}
          placeholder={"Search in conversation..."}
          size={16}
          classnames={"border-slate-300 border rounded-md"}
        />
      </form>
    </div>
  );
};

export default ChatHeader;
