import { useState } from "react";
import AuditForm from "./component/AuditForm";
import AuditResult from "./component/AuditResult";
import Loader from "./component/Loader";
import ErrorMessage from "./component/ErrorMessage";
import { analyzeWebsite } from "./service/apiAudit";

export default function App() {

    const [result, setResult] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    async function handleAnalyze(url) {

        setLoading(true);
        setError("");
        setResult(null);

        try {

            const data = await analyzeWebsite(url);
            setResult(data);

        } catch (err) {

            setError(err.message);

        } finally {

            setLoading(false);

        }

    }

    return (

        <div className="container">

            <h1>Page Pulse</h1>

            <p>Website SEO & Performance Auditor</p>

            <AuditForm
                onAnalyze={handleAnalyze}
                loading={loading}
            />

            {loading && <Loader />}

            <ErrorMessage message={error} />

            <AuditResult data={result} />

            <footer>
                Built for{" "}
                <a
                    href="https://digitalheroesco.com"
                    target="_blank"
                    rel="noreferrer"
                >
                    Digital Heroes Training Task
                </a>
            </footer>

        </div>

    );
}