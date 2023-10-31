import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "./ui/avatar";
import { girl_1 } from "@/assets/images";
import chatStore from "@/store/ChatStore";

const MessageBox = ({ isInitiator, data }) => {
  const setShowMessageOption = chatStore((state) => state.setShowMessageOption);
  const setSelectedMessage = chatStore((state) => state.setMessageSelected);
  const messageSelected = chatStore((state) => state.messageSelected);

  const handleMessageBoxClick = () => {
    if (messageSelected === data?.id) {
      setShowMessageOption(false);
      setSelectedMessage(null);
    } else {
      setShowMessageOption(true);
      setSelectedMessage(1);
    }
  };

  return (
    <div
      className={`flex items-end gap-3 ${
        isInitiator ? "flex-row-reverse self-end" : "self-start"
      }`}
    >
      <Avatar>
        <AvatarImage src={girl_1}></AvatarImage>
        <AvatarFallback>CN</AvatarFallback>
      </Avatar>
      <div
        className={`flex flex-col max-w-[250px] shadow-md rounded-xl p-4 cursor-pointer hover:scale-105 duration-100 ${
          isInitiator ? "bg-white" : "bg-gray-300"
        }`}
        onClick={handleMessageBoxClick}
      >
        <div className="mb-2">
          Lorem, ipsum dolor sit amet consectetur adipisicing elit. Accusantium
          sed quam.
        </div>
        <p className="self-end text-xs text-slate-400 font-normal">23:09</p>
      </div>
    </div>
  );
};

export default MessageBox;
