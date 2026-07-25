export default function AuditResult({ data }) {
  if (!data) return null;

  return (
    <div className="result-container">

      <h2>Audit Report</h2>

      <div className="card">
        <strong>SEO Score</strong>
        <p>{data.seoScore}/100</p>
      </div>

      <div className="card">
        <strong>HTTP Status</strong>
        <p>{data.httpStatus}</p>
      </div>

      <div className="card">
        <strong>Response Time</strong>
        <p>{data.responseTime} ms</p>
      </div>

      <div className="card">
        <strong>Title</strong>
        <p>{data.title || "N/A"}</p>
      </div>

      <div className="card">
        <strong>Meta Description</strong>
        <p>{data.metaDescription || "N/A"}</p>
      </div>

      <div className="card">
        <strong>H1 Count</strong>
        <p>{data.h1Count}</p>
      </div>

      <div className="card">
        <strong>Images Missing Alt</strong>
        <p>{data.imagesMissingAlt}</p>
      </div>

      <div className="card">
        <strong>Word Count</strong>
        <p>{data.wordCount}</p>
      </div>

      <div className="recommendations">
        <h3>Recommendations</h3>

        <ul>
          {data.recommendations.map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
      </div>

    </div>
  );
}