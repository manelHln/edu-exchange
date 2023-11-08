import { Badge } from "@/components/ui/badge";
import CustomBadge from "./CustomBadge";

const topics = ["Java", "Spring boot", "Programming", "Spring security"];

const colors = [
  "bg-blue-500",
  "bg-red-500",
  "bg-green-500",
  "bg-orange-500",
  "bg-purple-500",
  "bg-yellow-500",
];

// const colors = [
//   {
//     bg: "bg-blue-100",
//     text: "text-blue-400",
//   },
//   {
//     bg: "bg-red-100",
//     text: "text-red-400",
//   },
//   {
//     bg: "bg-green-100",
//     text: "text-green-400",
//   },
//   {
//     bg: "bg-orange-100",
//     text: "text-orange-400",
//   },
//   {
//     bg: "bg-purple-100",
//     text: "text-purple-400",
//   },
//   {
//     bg: "bg-yellow-100",
//     text: "text-yellow-400",
//   },
// ];

const FilterByTopicCard = () => {
  return (
    <div>
      <div className="flex flex-col w-full bg-white rounded-sm border border-slate-300 min-h-[100px]">
        <div className="w-full p-3 bg-slate-900 text-sm text-white font-semibold flex items-center rounded-t-sm">
          Filter by topic
        </div>
        <div className="flex flex-wrap gap-2 p-4">
          {topics.map((e, i) => {
            const randint = Math.floor(Math.random() * colors.length);
            return (
                <Badge key={`${e}-${i}`} className={`${colors[randint]} hover:${colors[randint]} p-2 cursor-pointer hover:opacity-80`}>
                  {e}
                </Badge>
            //   <CustomBadge
            //     key={`${e}-${i}`}
            //     content={e}
            //     textColor={colors[randint].text}
            //     bgColor={colors[randint].bg}
            //   />
            );
          })}
        </div>
      </div>
    </div>
  );
};

export default FilterByTopicCard;
