import React from "react";
import PostCard from "@/components/PostCard";
import InputWithIcon from "@/components/InputWithIcon";

const index = () => {
  return (
    <div className="bg-gray-200 sm:px-40 px-8 flex flex-wrap gap-4 h-full">
      <InputWithIcon
        name={"search"}
        placeholder={"Search"}
        size={16}
        classnames={"border-slate-300 border rounded-md mt-8"}
      />
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
  );
};

export default index;
