import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@radix-ui/react-avatar";
import {
  ArrowBigDownDash,
  ArrowBigUpDash,
  MessageCircle,
  MoreVertical,
} from "lucide-react";
import CustomBadge from "./CustomBadge";

const colors = [
  {
    bg: "bg-blue-100",
    text: "text-blue-400",
  },
  {
    bg: "bg-red-100",
    text: "text-red-400",
  },
  {
    bg: "bg-green-100",
    text: "text-green-400",
  },
  {
    bg: "bg-orange-100",
    text: "text-orange-400",
  },
  {
    bg: "bg-purple-100",
    text: "text-purple-400",
  },
  {
    bg: "bg-yellow-100",
    text: "text-yellow-400",
  },
];

const randint = Math.floor(Math.random() * colors.length);

const PostCard = () => {
  return (
    <div className="flex flex-col sm:flex-row justify-center items-center gap-6 flex-1 min-w-[300px] max-w-[400px] shadow-md bg-white rounded-md p-2 cursor-pointer">
      <div className="flex flex-col gap-2">
        <div className="flex justify-between items-center">
          <div className="flex gap-2 items-center">
            <Avatar>
              <AvatarImage src="girl1.png" width={40}></AvatarImage>
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>

            <div className="flex flex-col">
              <p className="text-xs text-slate-500">Edward Newgate</p>
              <p className="text-xs text-slate-500">@whitebeard</p>
            </div>
          </div>

          <MoreVertical size={18} className="cursor-pointer text-slate-500" />
        </div>

        <p className="text-sm text-slate-500 pb-2 border-b border-slate-200">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Odio minima
          similique sequi expedita aperiam.
        </p>

        <div className="flex justify-between items-center">
          <p className="text-xs text-slate-400 font-light">
            1:04 PM Feb 4, 2022
          </p>

          <div className="flex items-center gap-4">
            <div className="flex items-center gap-2 text-xs text-slate-400 font-light cursor-pointer hover:text-slate-700">
              <MessageCircle size={15} />
              <span className="">23</span>
            </div>

            {/* <div className="flex gap-4">
              <div className="flex gap-2 items-center text-green-400">
                <ArrowBigUpDash
                  size={15}
                  className="cursor-pointer duration-100 hover:text-green-700"
                />
                <span className="text-xs text-slate-400 font-light">3</span>
              </div>
              <div className="flex gap-2 items-center text-red-400">
                <ArrowBigDownDash
                  size={15}
                  className="cursor-pointer duration-100 hover:text-red-700"
                />
                <span className="text-xs text-slate-400 font-light">3</span>
              </div>
            </div> */}
          </div>
        </div>

        <div className="flex">
          <CustomBadge
            content="Programming"
            textColor={colors[randint].text}
            bgColor={colors[randint].bg}
          />
        </div>
      </div>
    </div>
  );
};

export default PostCard;
