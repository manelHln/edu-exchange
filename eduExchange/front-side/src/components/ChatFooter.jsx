import React from "react";
import { Trash2 } from "lucide-react";

const ChatFooter = ({ show }) => {
  return (
    <div
      className={`sticky bottom-0 bg-white z-10 border-b border-b-slate-400 justify-between items-center w-full p-4 ${
        show ? "flex" : "hidden"
      }`}
    >
      <div>
        <div></div>
      </div>
      <div className="flex">
        <Trash2 size={26} />
      </div>
    </div>
  );
};

export default ChatFooter;
