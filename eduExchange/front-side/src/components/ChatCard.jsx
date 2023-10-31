import { React } from "react";
import { girl_1 } from "@/assets/images";
import { dm_sans } from "@/utils/fonts";
import { Avatar, AvatarFallback, AvatarImage } from "./ui/avatar";

export function ChatCard({ props }) {
  const { fullname, userRole, message } = props;
  return (
    <div
      className={`flex justify-between items-center w-full p-2 rounded-md shadow-md bg-slate-100 hover:scale-105 cursor-pointer duration-150 ${dm_sans.className}`}
    >
      <div className="flex gap-4">
        <Avatar>
          <AvatarImage src={girl_1}></AvatarImage>
          <AvatarFallback>CN</AvatarFallback>
        </Avatar>
        <div className="flex flex-col">
          <span className="text-sm font-semibold">{fullname}</span>
          <span className="text-xs">{userRole}</span>
          <span className="text-xs truncate w-20">{message}</span>
        </div>
      </div>
      <span className="flex justify-center items-center h-6 w-6 bg-blue-400 rounded-[50%]">
        3
      </span>
    </div>
  );
}