import React, { useEffect } from "react";
import Router from "next/router";
import LoadingEffect from "@/components/LoadingEffect";
import "@/styles/globals.css";
import Layout from "@/components/layout";
import { ThemeProvider } from "@/components/theme-provider";

export default function App({ Component, pageProps }) {
  Router.events.on("routeChangeStart", () => <LoadingEffect />);
  return (
    <ThemeProvider
      attribute="class"
      defaultTheme="light"
      enableSystem
      disableTransitionOnChange
    >
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </ThemeProvider>
  );
}
