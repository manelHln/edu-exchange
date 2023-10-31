import ChatHeader from "@/components/ChatHeader";
import ChatSidebar from "@/components/ChatSidebar";
import ChatFooter from "@/components/ChatFooter";
import EmptyMain from "@/components/EmptyMain";
import React from "react";
import MessageBox from "@/components/MessageBox";
import chatStore from "@/store/ChatStore";

const Conversations = () => {
  const showFooter = chatStore((state)=> state.showMessageOption)
  return (
    <div className="w-full flex bg-gray-200">
      <ChatSidebar />
      <main className="w-full">
        <ChatHeader />
        <div className="flex flex-col gap-4 p-4">
          <MessageBox isInitiator />
          <MessageBox isInitiator />
          <MessageBox />
          <MessageBox isInitiator />
          <MessageBox />
          <MessageBox />
        </div>
        <ChatFooter show={showFooter} />
        {/* <EmptyMain /> */}
      </main>
    </div>
  );
};

export default Conversations;
