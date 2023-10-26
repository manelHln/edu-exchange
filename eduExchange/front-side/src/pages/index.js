import LandingPageNavbar from "@/components/LandingPageNavbar";
import LandingPageFooter from "@/components/LandingPageFooter";
import Banner from "@/components/Banner";
import SectionContainer from "@/components/SectionContainer";
import Features from "@/components/Features";
import { ActiveIcon, learn, message_1, message_2, myUser, user } from "@/assets/images";
import Cta from "@/components/Cta";
import Testimonials from "@/components/Testimonials";
import { ChatCard } from "@/components/ChatCard";
import Header from "@/components/Header";


const buttonAttributes = {
  text: "Start chatting now",
  classes:
    "cursor-pointer py-4 px-6 rounded-md text-white bg-custom-orange text-sm",
};

const counterAttributtes = [
  {
    count: "4.3K+",
    text: "Website <br /> Powering",
  },
  {
    count: "7M+",
    text: "Chats <br /> in last 2022",
  },
];

export default function Home() {
  return (
    <div>
      <LandingPageNavbar />
      <main>
        <div className="sm:px-40 px-8">
          <Banner />
        </div>

        <div className="sm:px-40 px-8">
          <Features />
        </div>

        <div className="sm:px-40 px-8 bg-bg-light">
          <SectionContainer
            title="Collaborate and <br /> share organizationnal knowledge"
            description="Our platform streamlines the exchange of knowledge, fostering innovation, and enhancing productivity across your organization."
            mockupImg={learn}
            reversed
          />
        </div>

        <div className="sm:px-40 px-8">
          <SectionContainer
            title="Real-time chatting <br /> between students<br /> and teachers"
            description="Enhance the educational experience with instant communication. Our app enables real-time chatting between teachers and classmates, promoting interactive discussions, quick question-and-answer sessions, and personalized support."
            button={buttonAttributes}
            mockupImg={message_2}
          />
        </div>

        <div className="sm:px-40 px-8 bg-bg-light">
          <SectionContainer
            title="Knowledge Exchange and Q&A Forums"
            description="Create custom landing pages with Rareblocks that converts more visitors than any website. With lots of unique blocks easily build a page. There are many variations of passages of available. "
            mockupImg={message_1}
            reversed
            counter={counterAttributtes}
          />
        </div>

    //     {/* <Testimonials /> */}

        <div className="sm:px-40 px-8">
          <Cta />
        </div>
      </main>
      <LandingPageFooter />
    </div>
  );
}
