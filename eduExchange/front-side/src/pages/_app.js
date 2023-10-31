import React, { useEffect } from "react";
import Router from "next/router";
import LoadingEffect from "@/components/LoadingEffect";
import "@/styles/globals.css";
import Layout from "@/components/layout";

export default function App({ Component, pageProps }) {
  Router.events.on("routeChangeStart", ()=> <LoadingEffect />)
  return (
      <Layout>
        <Component {...pageProps} />
      </Layout>
  );
}
