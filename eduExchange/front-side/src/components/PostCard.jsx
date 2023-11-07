import {
  ArrowBigDown,
  ArrowBigUp,
  MessageSquare,
  Flag
} from "lucide-react";

import Link from "next/link";

const PostCard = () => {
  return (
    <div className="flex flex-col sm:flex-row gap-3 w-full bg-white rounded-sm border border-slate-300">
      <div className="text-slate-500 flex flex-col items-center h-full bg-slate-50 p-2">
        <ArrowBigUp className="cursor-pointer" />
        <span>23</span>
        <ArrowBigDown className="cursor-pointer" />
      </div>

      <div className="flex flex-col gap-2 py-2">
        <div className="flex items-center gap-2">
          <p className="font-semibold text-sm">r/programming</p>
          <span className="text-slate-400 text-xs">
            Posted by John Doe 12 hours ago
          </span>
        </div>

        <Link className="cursor-pointer" href="/posts/1">
          <p className="text-sm text-slate-600 font-light">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate
            nobis quia, minus modi itaque ea aperiam, exercitationem error atque
            iusto necessitatibus deleniti hic tempora corrupti. A sed facilis
            accusamus ratione!
          </p>
        </Link>
        <div className="flex items-center text-slate-500 gap-4 font-semibold">
          <div className="flex items-center gap-1 cursor-pointer">
            <MessageSquare size={16} />{" "}
            <span className="text-sm">73 comments</span>
          </div>
          <div className="flex items-center gap-1 cursor-pointer">
            <Flag size={16} />{" "}
            <span className="text-sm">Report</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PostCard;
