import React from "react";
import { ChatCard } from "./ChatCard";
import { PlusIcon } from "lucide-react";
import { dm_sans } from "@/utils/fonts";

const user = {
  fullname: "Michael B",
  userRole: "Teacher",
  message: "Sent you a file",
};

const ChatSidebar = ({ props }) => {
  return (
    <div className="flex flex-col items-center w-1/4 sticky top-0 bottom-0 h-screen p-4 overflow-scroll overflow-x-hidden">
      <div className="flex justify-between items-center w-full pb-4 mb-4">
        <h2 className={`${dm_sans.className} text-3xl font-semibold`}>Inbox</h2>
        <PlusIcon size={24} className="cursor-pointer" />
      </div>
      <div className="flex flex-col gap-2 w-full">
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
        <ChatCard props={user} />
      </div>
    </div>
  );
};

export default ChatSidebar;
