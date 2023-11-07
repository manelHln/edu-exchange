import React, { useRef, useState } from "react";
import PostCard from "@/components/PostCard";
import PostPageNavbar from "@/components/PostPageNavbar";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Image, Link } from "lucide-react";
import CreatePostCard from "@/components/CreatePostCard";
import CreatePostForm from "@/components/CreatePostForm";
import { Modal } from "@/components/Modal";
import { Button } from "@/components/ui/button";
import Icon from "@/components/Icon";
import PostRuleCard from "@/components/PostRuleCard";
import FilterByTopicCard from "@/components/FilterByTopicCard";
import TeachersListCard from "@/components/TeachersListCard";

const index = () => {
  const [isModalOpen, setIsModalOPen] = useState(false);
  const fileUploadInputRef = useRef(null);

  const closeModal = () => setIsModalOPen(false);

  const handleFileUpload = () => {
    if (fileUploadInputRef.current) {
      fileUploadInputRef.current.click();
    }
  };
  return (
    <div className="bg-slate-200 min-h-screen">
      <PostPageNavbar />
      <main className="px-8 sm:px-40 flex gap-8">
        <div className="flex flex-col flex-wrap gap-4 mt-4 w-2/3">
          <div className="flex items-center gap-2 p-2 bg-white rounded-sm border border-slate-300">
            <Avatar>
              <AvatarImage src="girl1.png" width={40}></AvatarImage>
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
            <input type="file" className="hidden" ref={fileUploadInputRef} />
            <div className="flex-1">
              <Modal
                title={"Create Post"}
                isOpen={isModalOpen}
                onclose={() => setIsModalOPen((prev) => !prev)}
                triggerButton={
                  <div>
                    <Button
                      size="icon"
                      className="flex justify-start items-center rounded-sm w-full text-slate-400 px-4"
                      onClick={() => setIsModalOPen(true)}
                      variant="outline"
                    >Create Post</Button>
                  </div>
                }
                description="Create a new post"
                body={<CreatePostForm closeModal={closeModal} />}
                footer={""}
              />
            </div>
            {/* <input
              type="text"
              placeholder="Create Post"
              className="border border-slate-300 bg-slate-100 rounded-sm w-full p-2 focus:outline-none"
            /> */}
            <div className="flex gap-2 text-slate-400">
              <Image
                size={20}
                className="cursor-pointer"
                onClick={handleFileUpload}
              />
              {/* <Link size={20} className="cursor-pointer" /> */}
            </div>
          </div>
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
        </div>

        <div className="mt-4 flex flex-col flex-1 gap-4">
          <PostRuleCard />
          <FilterByTopicCard />
          <CreatePostCard />
          <TeachersListCard />
        </div>
      </main>
    </div>
  );
};

export default index;
