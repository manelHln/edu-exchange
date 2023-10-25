import React from "react";
import FeatureCard from "./FeatureCard";
import { video, safe, time } from "@/assets/images";
import { montserrat } from "@/utils/fonts";

const features = [
  {
    title: "Ask Questions",
    icon: video,
    desc: "Don't understand a concept? Have a problem? Ask, and you'll receive quick responses from your peers or teachers.",
  },
  {
    title: "Share Your Knowledge",
    icon: time,
    desc: "Showcase your expertise by helping your classmates, rating the most helpful answers, and building your reputation as an active learner.",
  },
  {
    title: "Learn Together",
    icon: safe,
    desc: "Collaborate on exercises, share resources, and develop your skills through a knowledge-sharing community.",
  },
];

const Features = () => {
  return (
    <div className="py-20 flex flex-col justify-center items-center gap-12 text-center sm:text-left">
      <div className="flex flex-col flex-1 items-center justify-center gap-4">
        <h2
          className={`text-4xl font-bold text-black-primary capitalize ${montserrat.className}`}
        >
          what you can expect from our platform
        </h2>
        <p className="sm:w-[70%] text-md text-light-primary text-center">
          We understand the challenges students and teachers face, which is why
          we created EduExchange.
        </p>
      </div>

      <div className="flex justify-between items-center flex-wrap gap-4">
        {features.map((e, i) => (
          <FeatureCard
            key={`${e.title.split(" ")[0]}-${i}`}
            title={e.title}
            description={e.desc}
            icon={e.icon}
          />
        ))}
      </div>
    </div>
  );
};

export default Features;
