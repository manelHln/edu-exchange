import { useRef } from "react";
import { ArrowBigDown, ArrowBigUp, MessageSquare, Flag } from "lucide-react";
import PostPageNavbar from "@/components/PostPageNavbar";
import { Editor } from "@tinymce/tinymce-react";
import { Button } from "@/components/ui/button";
import Comment from "@/components/Comment";
import { useToast } from "@/components/ui/use-toast";

const SinglePostPage = () => {
  const { toast } = useToast();
  const editorRef = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (editorRef.current) {
      if (!editorRef.current.getContent()) {
        toast({
          title: "OOps",
          description: "Please field cannot be empty!",
          variant: "destructive",
        });
        return;
      }
    }
  };

  return (
    <div className="bg-slate-200 min-h-screen">
      <PostPageNavbar />
      <main className="px-8 sm:px-52 py-10 flex gap-8">
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

            <div>
              <p className="text-sm text-slate-600 font-light">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Cupiditate nobis quia, minus modi itaque ea aperiam,
                exercitationem error atque iusto necessitatibus deleniti hic
                tempora corrupti. A sed facilis accusamus ratione! Lorem ipsum
                dolor sit amet consectetur adipisicing elit. Cupiditate nobis
                quia, minus modi itaque ea aperiam, exercitationem error atque
                iusto necessitatibus deleniti hic tempora corrupti. A sed
                facilis accusamus ratione!
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
            </div>

            <form
              className="border-b border-b-slate-200 py-4 grid gap-4"
              onSubmit={handleSubmit}
            >
              <Editor
                apiKey={process.env.NEXT_PUBLIC_TINYMCE_KEY}
                onInit={(event, editor) => (editorRef.current = editor)}
                init={{
                  height: 300,
                  menubar: false,
                  plugins: [
                    "advlist autolink lists link image charmap print preview anchor",
                    "searchreplace visualblocks code fullscreen",
                    "insertdatetime media table code help wordcount",
                  ],
                  toolbar:
                    "undo redo | formatselect | " +
                    "bold italic backcolor | alignleft aligncenter " +
                    "alignright alignjustify | bullist numlist outdent indent | " +
                    "removeformat | help",
                  content_style:
                    "body { font-family:Helvetica,Arial,sans-serif; font-size:14px }",
                }}
              />
              <div>
                <Button
                  variant="outline"
                  type="submit"
                  className="bg-slate-200 flex items-center gap-1 text-slate-500 text-sm rounded-full"
                >
                  Comment
                </Button>
              </div>
            </form>

            <Comment />
          </div>
        </div>
      </main>
    </div>
  );
};

export default SinglePostPage;
