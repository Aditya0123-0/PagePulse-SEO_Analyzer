import { useState } from "react";

export default function AuditForm({ onAnalyze, loading }) {
  const [url, setUrl] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!url.trim()) {
      alert("Please enter a URL.");
      return;
    }

    onAnalyze(url.trim());
  };

  return (
    <form className="audit-form" onSubmit={handleSubmit}>
      <input
        type="url"
        placeholder="https://example.com"
        value={url}
        onChange={(e) => setUrl(e.target.value)}
        required
      />

      <button type="submit" disabled={loading}>
        {loading ? "Analyzing..." : "Analyze"}
      </button>
    </form>
  );
}