import { ArrowBigDown, ArrowBigUp, MessageSquare, Flag } from "lucide-react";
import Image from "next/image";
import { girl_1 } from "@/assets/images";
import UserInfoSheet from "./UserInfoSheet";

const Comment = ({ data }) => {
  return (
    <div className="flex flex-col gap-3 w-2/3">
      <div className="flex flex-col gap-2 py-2">
        <div className="flex items-center gap-2">
          {/* <Image src={girl_1} alt="User avatar" width={20} height={20} /> */}
          <UserInfoSheet />
          <p className="text-sm">Edward Newgate</p>
          {/* <span className="text-slate-400 text-xs">
            12 hours ago
          </span> */}
        </div>

        <div>
          <div
            className="text-sm text-slate-600 font-light"
            dangerouslySetInnerHTML={{ __html: data.content }}
          ></div>
        </div>
        <div className="flex items-center text-slate-500 gap-4 font-semibold">
          <div className="flex items-center gap-1">
            <ArrowBigUp size={20} className="cursor-pointer" />
            <span className="text-xs">23</span>
            <ArrowBigDown size={20} className="cursor-pointer" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Comment;
