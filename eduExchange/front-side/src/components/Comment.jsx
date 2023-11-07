import { ArrowBigDown, ArrowBigUp, MessageSquare, Flag } from "lucide-react";
import Image from "next/image";
import { girl_1 } from "@/assets/images";
import UserInfoSheet from "./UserInfoSheet";

const Comment = () => {
  return (
    <div className="flex flex-col gap-3 w-2/3">
      <div className="flex flex-col gap-2 py-2">
        <div className="flex items-center gap-2">
        {/* <Image src={girl_1} alt="User avatar" width={20} height={20} /> */}
        <UserInfoSheet />
          <p className="text-sm">Edward Newgate</p>
          <span className="text-slate-400 text-xs">
            12 hours ago
          </span>
        </div>

        <div>
          <p className="text-sm text-slate-600 font-light">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate
            nobis quia, minus modi itaque ea aperiam, exercitationem error atque
            iusto necessitatibus deleniti hic tempora corrupti. A sed facilis
            accusamus ratione! Lorem ipsum dolor sit amet consectetur
            adipisicing elit.
          </p>
        </div>
        <div className="flex items-center text-slate-500 gap-4 font-semibold">
          <div className="flex items-center gap-1 cursor-pointer">
            <MessageSquare size={16} />{" "}
            <span className="text-sm">73 comments</span>
          </div>
          <div className="flex items-center gap-1 cursor-pointer">
            <Flag size={16} /> <span className="text-sm">Report</span>
          </div>
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
